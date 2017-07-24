package app;

import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
public class Sales {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("salesdb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Sale sale = InicialiseAndGetSale(em);
        em.persist(sale);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static Sale InicialiseAndGetSale(EntityManager em) {
        Product audi = new Product();
        audi.setName("Audi S8");
        audi.setQuantity_price(new BigDecimal(100000));

        Customer roman = new Customer();
        roman.setName("Roman Abramovic");
        roman.setCreditCardNumber("123654789");
        roman.setEmail("roman@abv.bg");

        StoreLocation chukotka = new StoreLocation();
        chukotka.setLocationName("Chukotka, Russia");

        Sale sale = new Sale();
        sale.setCustomer(roman);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 9, 03);
        Date someDate = calendar.getTime();
        sale.setDate(someDate);
        sale.setProduct(audi);
        sale.setStoreLocation(chukotka);

        Set<Sale> romanSale = new HashSet<Sale>() {{
            add(sale);
        }};

        em.persist(audi);
        em.persist(roman);
        em.persist(chukotka);

        return sale;
    }
}
