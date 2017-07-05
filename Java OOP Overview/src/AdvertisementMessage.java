import java.util.Random;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] phases = new String[]
                {
                        "Excellent product.",
                        "Such a great product.",
                        "I always use that product.",
                        "Best product of its category.",
                        "Exceptional product.",
                        "I can’t live without this product."
                };
        String[] events = new String[]
                {
                        "Now I feel good.",
                        "I have succeeded with this product.",
                        "Makes miracles. I am happy of the results!",
                        "I cannot believe but now I feel awesome.",
                        "Try it yourself, I am very satisfied.",
                        "I feel great!"
                };
        String[] authors = new String[]
                {
                        "Diana",
                        "Petya",
                        "Stella",
                        "Elena",
                        "Katya",
                        "Iva",
                        "Annie",
                        "Eva"
                };
        String[] cities = new String[]
                {
                        "Burgas",
                        "Sofia",
                        "Plovdiv",
                        "Varna",
                        "Ruse"
                };

        int n = Integer.parseInt(in.nextLine());
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int indexPhase = rand.nextInt(phases.length);
            int indexEvent = rand.nextInt(events.length);
            int indexAuthor = rand.nextInt(authors.length);
            int indexCity = rand.nextInt(cities.length);

            System.out.printf("%s %s %s - %s", phases[indexPhase], events[indexEvent], authors[indexAuthor], cities[indexCity]);
        }
    }
}
