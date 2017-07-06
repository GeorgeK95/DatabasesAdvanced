package Animals;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void produceSound() {
        System.out.println("Give me one million b***h");
    }
}
