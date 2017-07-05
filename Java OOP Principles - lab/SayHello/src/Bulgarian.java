/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Bulgarian extends BasePerson  implements Person{
    private String name;

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
