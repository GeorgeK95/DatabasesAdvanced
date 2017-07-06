package Animals;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    protected void produceSound() {
        System.out.println("Not implemented!");
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    public String getGender() {
        if (gender == null || (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female"))) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return gender;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
