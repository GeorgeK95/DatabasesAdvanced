package BorderControl;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class BorderControl implements Guest {
    private String name;
    private int age = 0;
    private String id;

    public BorderControl(String name, int age, String id) {
        //person
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public BorderControl(String name, String id) {
        //robot
        this.name = name;
        this.id = id;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isFake(String id) {
        String substr = this.getId().substring(this.getId().length() - id.length());

        if (substr.equals(id)) {
            return true;
        }

        return false;
    }

    @Override
    public String getNameOrModel() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
