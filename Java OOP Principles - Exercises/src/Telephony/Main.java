package Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        String[] urls = reader.readLine().split(" ");

        for (String number : numbers) {
            Callable call = new Smartphone();
            call.setNumber(number);
        }

        for (String url : urls) {
            Browseable browseable = new Smartphone();
            browseable.setUrl(url);
        }
    }
}
