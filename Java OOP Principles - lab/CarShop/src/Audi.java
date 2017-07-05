

public class Audi implements Rentable {
    private String model;
    private String color;
    private int horsePower;
    private String countryProducer;
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProducer, Integer minRentDay, Double pricePerDay) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProducer(countryProducer);
        this.setMinRentDay(minRentDay);
        this.setPricePerDay(pricePerDay);
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private void setCountryProducer(String countryProducer) {
        this.countryProducer = countryProducer;
    }

    private void setMinRentDay(int minRentDay) {
        this.minRentDay = minRentDay;
    }

    private void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getCountryProducer() {
        return this.countryProducer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                this.getModel(), this.getCountryProducer(), Car.TIRES);
    }
}