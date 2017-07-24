package app;

import entities.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@SuppressWarnings("ALL")
public class BankDb {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankdb1");
    public static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
//        addDataToDb(em);
        task_10();
        emf.close();
    }

    private static void task_10() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] spl = line.split("\\s+");

        if (!isLoggedUser()) {
            switch (spl[0]) {
                case "Register":
                    doRegister(spl);
                    break;
                case "Login":
                    doLogin(spl);
                    break;
                case "Logout":
                    printLogoutResult();
                    break;
            }
        } else {
            switch (spl[0]) {
                case "Logout":
                    doLogout();
                    break;
                case "Add":
                    doAdd(spl);
                    break;
                case "ListAccounts":
                    doList();
                    break;
                case "Deposit":
                    doDeposit(spl);
                    break;
                case "Withdraw":
                    doWithdraw(spl);
                    break;
                case "DeductFee":
                    doDeductFee(spl);
                    break;
                case "AddInterest":
                    doAddInterest(spl);
                    break;
            }
        }

    }

    private static void doAddInterest(String[] spl) {
        String num = spl[1];

        em.getTransaction().begin();

        String query = "select ba from BaseAccount as ba where accountNumber = :num";
        SaveAccount ba = (SaveAccount) em.createQuery(query).setParameter("num", num).getSingleResult();
        ba.addInterest();
        em.persist(ba);
        em.getTransaction().commit();
        em.close();

        System.out.println("Added interest to " + num + ". Current balance: " + ba.getBalance());
    }

    private static void doDeductFee(String[] spl) {
        String num = spl[1];

        em.getTransaction().begin();

        String query = "select ba from BaseAccount as ba where accountNumber = :num";
        CheckAccount ba = (CheckAccount) em.createQuery(query).setParameter("num", num).getSingleResult();
        ba.deductFee();
        em.persist(ba);
        em.getTransaction().commit();
        em.close();

        System.out.println("Deducted fee of " + num + ". Current balance: " + ba.getBalance());
    }

    private static void doWithdraw(String[] spl) {
        String num = spl[1];
        BigDecimal mon = BigDecimal.valueOf(Double.parseDouble(spl[2]));

        em.getTransaction().begin();

        String query = "select ba from BaseAccount as ba where accountNumber = :num";
        BaseAccount ba = (BaseAccount) em.createQuery(query).setParameter("num", num).getSingleResult();
        ba.withdrawMoney(mon);

        em.persist(ba);
        em.getTransaction().commit();
        em.close();

        System.out.println("Account " + num + " has balance of " + ba.getBalance());
    }

    private static void doDeposit(String[] spl) {
        String num = spl[1];
        BigDecimal mon = BigDecimal.valueOf(Double.parseDouble(spl[2]));

        em.getTransaction().begin();

        String query = "select ba from BaseAccount as ba where accountNumber = :num";
        BaseAccount ba = (BaseAccount) em.createQuery(query).setParameter("num", num).getSingleResult();
        ba.depositMoney(mon);

        em.persist(ba);
        em.getTransaction().commit();
        em.close();

        System.out.println("Account " + num + " has balance of " + ba.getBalance());
    }

    private static void doList() {
        User u = getLoggedInUser();

        System.out.println("Saving Accounts:");
        String query = "select ba from SaveAccount as ba where user = :us";
        List<SaveAccount> ba = (List<SaveAccount>) em.createQuery(query).setParameter("us", u).getResultList();
        for (SaveAccount baseAccount : ba) {
            System.out.printf("--%s %s\n", baseAccount.getAccountNumber(), baseAccount.getBalance());
        }
        System.out.println("Checking Accounts:");
        String query2 = "select ba from CheckAccount as ba where user = :us";
        List<CheckAccount> ca = (List<CheckAccount>) em.createQuery(query2).setParameter("us", u).getResultList();
        for (CheckAccount checkAccount : ca) {
            System.out.printf("--%s %s\n", checkAccount.getAccountNumber(), checkAccount.getBalance());
        }
    }

    private static void doAdd(String[] spl) {
        switch (spl[1]) {
            case "SavingsAccount":
                addSaveAcc(spl);
                break;
            case "CheckingAccount":
                addCheckAcc(spl);
                break;
        }
    }

    private static void addCheckAcc(String[] spl) {
        BigDecimal bal = BigDecimal.valueOf(Double.parseDouble(spl[2]));
        BigDecimal fee = BigDecimal.valueOf(Double.parseDouble(spl[3]));

        CheckAccount ca = new CheckAccount();
        ca.setFee(fee);
        ca.setBalance(bal);
        ca.setAccountNumber(generateRandomNumber());
        ca.setUser(getLoggedInUser());

        em.getTransaction().begin();
        em.persist(ca);
        em.getTransaction().commit();
        em.close();

        System.out.println("Succesfully added account with number " + ca.getAccountNumber());
    }

    private static void addSaveAcc(String[] spl) {
        BigDecimal bal = BigDecimal.valueOf(Double.parseDouble(spl[2]));
        BigDecimal rate = BigDecimal.valueOf(Double.parseDouble(spl[3]));

        SaveAccount sa = new SaveAccount();
        sa.setRate(rate);
        sa.setBalance(bal);
        sa.setAccountNumber(generateRandomNumber());
        sa.setUser(getLoggedInUser());

        em.getTransaction().begin();
        em.persist(sa);
        em.getTransaction().commit();
        em.close();

        System.out.println("Succesfully added account with number " + sa.getAccountNumber());
    }

    public static String generateRandomNumber() {
        StringBuilder sb = new StringBuilder();
        String regex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randNum = rand.nextInt(36);
            sb.append(regex.charAt(randNum));
        }

        return sb.toString();
    }

    private static User getLoggedInUser() {
        String query = "select lu FROM LogUser lu where isLogged = 1";
        try {
            LogUser logUser = (LogUser) em.createQuery(query).getSingleResult();
            if (logUser.isLogged()) {
                return logUser.getUser();
            }
        } catch (NoResultException e) {
        }
        return null;
    }

    private static boolean isLoggedUser() {
        String query = "select lu FROM LogUser lu";
        List<LogUser> logUsers = em.createQuery(query).getResultList();
        logUsers = logUsers.stream().filter(x -> x.isLogged() == true).collect(Collectors.toList());

        return logUsers.size() > 0 ? true : false;
    }

    private static void doLogout() {
        User u = getLoggedInUser();
        if (u == null) {
            System.out.println("Cannot log out. No user was logged in.");
        } else {
            String query = "select lu FROM LogUser lu where isLogged = 1";
            List<LogUser> logUsers = (List<LogUser>) em.createQuery(query).getResultList();
            em.getTransaction().begin();
            for (LogUser logUser : logUsers) {
                logUser.setLogged(false);
                em.persist(logUser);
            }
            em.getTransaction().commit();
            em.close();
            System.out.printf("User %s successfully logged out\n", u.getUserName());
        }
    }

    private static void printLogoutResult() {
        System.out.println("Cannot log out. No user was logged in.");
    }

    private static void doLogin(String[] spl) {
        User u = getLoggedInUser();
        if (u == null) {
            try {
                User us = getUser(spl[1], spl[2]);
                if (us!=null){
                    logUserIn(us);
                    System.out.println("Succesfully logged in " + us.getUserName());
                }
            } catch (NullPointerException e) {
                System.out.println("Incorrect username / password");
            }
        }
    }

    private static void logUserIn(User us) {
        em.getTransaction().begin();
        String query = "select u FROM LogUser u where u.user = :us";
        LogUser q = (LogUser) em.createQuery(query).setParameter("us", us).getSingleResult();
        q.setLogged(true);
        em.getTransaction().commit();
        em.close();
    }

    private static void doRegister(String[] spl) {
        User us = new User();
        us.setUserName(spl[1]);
        us.setPassword(spl[2]);
        us.setEmail(spl[3]);
        registerUser(us);
    }

    private static void registerUser(User us) {
        em.getTransaction().begin();
        LogUser lu = new LogUser();
        lu.setUser(us);
        lu.setLogged(false);
        em.persist(us);
        em.persist(lu);
        em.getTransaction().commit();
        em.close();
        System.out.println(us.getUserName() + " was registered in the system");
    }

    private static User getUser(String s, String s1) {
        String query = "select u FROM User u where u.userName = :un and u.password = :ps";
        Query q = em.createQuery(query).setParameter("un", s).setParameter("ps", s1);

        try {
            User found = (User) q.getSingleResult();
            return found;
        } catch (NoResultException e) {
            System.out.println("Incorrect username / password");
        }

        return null;
    }

    private static void addDataToDb(EntityManager em) {
        em.getTransaction().begin();

        SaveAccount sa = new SaveAccount();
        sa.setRate(new BigDecimal(0.2));
        sa.setAccountNumber("789654123");
        sa.setBalance(new BigDecimal(8955));

        CheckAccount ca = new CheckAccount();
        ca.setBalance(new BigDecimal(9866));
        ca.setAccountNumber("123123123");
        ca.setFee(new BigDecimal(10.20));

        sa.depositMoney(new BigDecimal(10000));
        sa.withdrawMoney(new BigDecimal(5000));
        sa.addInterest();

        ca.depositMoney(new BigDecimal(10000));
        ca.withdrawMoney(new BigDecimal(2000));
        ca.deductFee();

        em.persist(sa);
        em.persist(ca);
        em.getTransaction().commit();
        em.close();
    }
}
