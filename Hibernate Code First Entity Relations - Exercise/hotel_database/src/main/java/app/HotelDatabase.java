package app;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
public class HotelDatabase {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hoteldb");
        EntityManager em = emf.createEntityManager();
        AddData(em);
        emf.close();
    }

    private static void AddData(EntityManager em) {
        em.getTransaction().begin();
        Employee employee = new Employee();
        employee.setFirstName("Ivan");
        employee.setLastName("Trifonov");
        employee.setTitle("Project Manager.");
        em.persist(employee);

        Customer customer = new Customer();
        customer.setAccountNumber("123654789");
        customer.setFirstName("Rey");
        customer.setLastName("Misterio");
        customer.setPhoneNumber("08879654123");
        customer.setEmergencyName("ReyEmergencyName");
        customer.setEmergencyNumber("08879654123-EMERGENCY");
        em.persist(customer);

        RoomStatus rs = new RoomStatus();
        rs.setRoomStatus("reserved");//isAvailable
        em.persist(rs);

        RoomType rt = new RoomType();
        rt.setRoomType("Big Room");
        em.persist(rt);

        BedType bt = new BedType();
        bt.setBedType("Medium Bed");
        em.persist(bt);

        Room room = new Room();
        room.setRoomNumber("roomn7788");
        room.setRoomType(rt);
        room.setBedType(bt);
        room.setRate(new BigDecimal(10));
        room.setRoomStatus(rs);
        em.persist(room);

        Occupancy occupancy = new Occupancy();
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 07, 07);
        Date date = cal.getTime();
        occupancy.setDateOccupied(date);
        occupancy.setAccountNumber(customer);
        occupancy.setRoomNumber(room);
        occupancy.setRateApplied(new BigDecimal(9.3));
        occupancy.setPhoneCharge("78988977");
        em.persist(occupancy);

        Payment payment = new Payment();
        payment.setPaymentDate(date);
        payment.setAccountNumber(customer);

        payment.setFirstDateOccupied(occupancy);
        payment.setLastDateOccupied(occupancy);

        payment.setTotalDays(59);
        payment.setAmountCharged(new BigDecimal(22));
        payment.setTaxRate(new BigDecimal(21));
        payment.setTaxAmount(new BigDecimal(19));
        payment.setPaymentTotal(new BigDecimal(565));
        em.persist(payment);

        em.getTransaction().commit();
        em.close();
    }
}
