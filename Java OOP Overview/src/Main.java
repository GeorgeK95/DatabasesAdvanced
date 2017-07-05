//package Problem_06_ShoppingSpree;
//
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        String[] personsArgs = scanner.nextLine().trim().split(";");
//        Map<String, Person> persons = new LinkedHashMap<>();
//        for (String personsArg : personsArgs) {
//            String[] pArgs = personsArg.trim().split("=");
//            try{
//                Person newPerson = new Person(pArgs[0], Double.parseDouble(pArgs[1]));
//                persons.put(pArgs[0], newPerson);
//            } catch (IllegalArgumentException ex) {
//                System.out.println(ex.getMessage());
//                return;
//            }
//        }
//
//        String[] productsArgs = scanner.nextLine().trim().split(";");
//        Map<String, Product> products = new LinkedHashMap<>();
//        for (String productsArg : productsArgs) {
//            String[] pArgs = productsArg.trim().split("=");
//            try{
//                Product product = new Product(pArgs[0], Double.parseDouble(pArgs[1]));
//                products.put(pArgs[0], product);
//            } catch (IllegalArgumentException ex){
//                System.out.println(ex.getMessage());
//                return;
//            }
//        }
//
//        String command = scanner.nextLine();
//        while (!command.toLowerCase().equals("end")) {
//            String[] cmdArgs = command.trim().split("\\s+");
//
//            Person tempPerson = persons.get(cmdArgs[0]);
//            Product tempProduct = products.get(cmdArgs[1]);
//
//            tempPerson.buyProduct(tempProduct);
//
//            command = scanner.nextLine();
//        }
//
//        for (Person person : persons.values()) {
//            System.out.println(person);
//        }
//    }
//}
