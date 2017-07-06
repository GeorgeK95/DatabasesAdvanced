package Animals;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void produceSound() {
        System.out.println("MiauMiau");
    }
}
