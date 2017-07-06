package Animals;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Dog extends Animal{

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void produceSound() {
        System.out.println("BauBau");
    }
}
