package Telephony;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public final class Smartphone implements Browseable, Callable {
    private String number;
    private String url;

    public Smartphone() {
    }

    @Override
    public void setNumber(String number) {
        if (!isNumberValid(number)) {
            System.out.println("Invalid number!");
        } else {
            this.number = number;
            this.call();
        }

    }

    @Override
    public void setUrl(String url) {
        if (!isUrlValid(url)) {
            System.out.println("Invalid URL!");
        } else {
            this.url = url;
            this.browse();
        }
    }

    @Override
    public void call() {
        System.out.println("Calling... " + this.number);
    }

    @Override
    public void browse() {
        System.out.println("Browsing: " + this.url + "!");
    }

    private boolean isNumberValid(String number) {
        for (int i = 0; i < number.length(); i++) {
            char curr = number.charAt(i);

            if (curr < 48 || curr > 57) {
                return false;//there is a symbol different from number
            }
        }

        return true;
    }

    private boolean isUrlValid(String url) {
        for (char curr : url.toCharArray()) {
            if (curr >= 48 && curr <= 57) {
                return false;//there is a number
            }
        }

        return true;
    }
}
