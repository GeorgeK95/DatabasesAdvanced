package Animals;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void produceSound() {
        System.out.println("Frogggg");
    }
}
