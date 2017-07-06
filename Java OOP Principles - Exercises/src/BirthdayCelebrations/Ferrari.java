package BirthdayCelebrations;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Ferrari implements Car {
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public void getModel() {
        System.out.print("488-Spider/");
    }

    @Override
    public void touchBrakes() {
        System.out.print("Brakes!/");
    }

    @Override
    public void touchGas() {
        System.out.print("Zadu6avam sA!/");
    }

    @Override
    public void getDriverName() {
        System.out.print(this.driver);
    }

    @Override
    public String toString() {
        getModel();
        touchBrakes();
        touchGas();
        getDriverName();
        return "";
    }
}
