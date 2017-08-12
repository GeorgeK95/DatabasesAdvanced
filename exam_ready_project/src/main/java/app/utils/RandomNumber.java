package app.utils;

import java.util.Random;

public final class RandomNumber {

    private RandomNumber() {
    }

    public static int getRandomNumber(int bound) {
        Random r = new Random();
        return r.nextInt(bound) + 1;
//        return (int) (Math.random() * (bound + 1));
    }

    public static int getRandomNumber(int min, int max) {
        Random r = new Random();
        int i = r.nextInt(max) + 1;
        if (i < min) {
            i += min;
        }
        return i;
//        return (int) (min + (Math.random() * (max - min)));
    }
}
