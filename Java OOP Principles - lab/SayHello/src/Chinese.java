/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Chinese extends BasePerson  implements Person{

    private String name;

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
