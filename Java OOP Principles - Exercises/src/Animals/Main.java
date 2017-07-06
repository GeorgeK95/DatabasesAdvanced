package Animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String command = in.nextLine();
        while (!command.equals("Beast!")) {
            String animalKind = command;
            String[] animalArgs = in.nextLine().split("\\s+");
            if (animalArgs.length >= 2) {
                String name = animalArgs[0];
                int age = Integer.parseInt(animalArgs[1]);

                Animal animal = null;
                try {
                    if (animalKind.equals("Animal")) {
                        if (animalArgs.length == 3) {
                            String gender = animalArgs[2];
                            animal = new Animal(name, age, gender);
                        }
                    } else if (animalKind.equals("Dog")) {
                        if (animalArgs.length == 3) {
                            String gender = animalArgs[2];
                            animal = new Dog(name, age, gender);
                        }
                    } else if (animalKind.equals("Cat")) {
                        if (animalArgs.length == 3) {
                            String gender = animalArgs[2];
                            animal = new Cat(name, age, gender);
                        }
                    } else if (animalKind.equals("Kitten")) {
                        animal = new Kitten(name, age, "Female");
                    } else if (animalKind.equals("Tomcat")) {
                        animal = new Tomcat(name, age, "Male");
                    } else if (animalKind.equals("Frog")) {
                        if (animalArgs.length == 3) {
                            String gender = animalArgs[2];
                            animal = new Frog(name, age, gender);
                        }
                    }

                    if (animal == null) {
                        System.out.println("Invalid input!");
                    } else {
                        System.out.println(animalKind);
                        System.out.println(animal);
                        animal.produceSound();
                    }
                } catch (Exception iae) {
                    System.out.println(iae.getMessage());
                }
            }

            command = in.nextLine();
        }
    }
}