package app.utils;

public final class RandomNumber {

    private RandomNumber() {
    }

    public static int getRandomNumber(int bound) {
//        Random r = new Random();
//        return r.nextInt(bound) + 1;
        return (int) (Math.random() * (bound + 1));
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}
