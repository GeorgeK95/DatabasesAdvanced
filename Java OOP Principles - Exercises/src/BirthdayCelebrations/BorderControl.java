package BirthdayCelebrations;

import java.util.Date;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class BorderControl implements Guest {
    private String type;
    private String name;
    private int age = 0;
    private String id = "";
    private String birthdate = "";

    public BorderControl(String type, String name, int age, String id, String birthdate) {
        //person
        this.type = type;
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    public BorderControl(String type, String name, String id) {
        //robot and pet
        if (type.equals("Pet")) {
            this.type = type;
            this.name = name;
            this.birthdate = id;
        } else if (type.equals("Robot")) {
            this.type = type;
            this.name = name;
            this.id = id;
        }
    }

    public BorderControl(String name, String birthdate) {
        //pet
        this.name = name;
        this.birthdate = birthdate;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
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
    public boolean compareYear(String yearParam) {
        if (this.getBirthdate().endsWith(yearParam)) {
            return true;
        }

        return false;
    }

    @Override
    public String getType() {
        return this.type;
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
