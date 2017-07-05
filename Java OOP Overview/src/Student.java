class Student {
    public static int getCounter() {
        return counter;
    }

    private static int counter = 0;
    public Double grade;
    public String name;

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Double grade, String name) {
        this.grade = grade;
        this.name = name;
        this.counter++;
    }

    public Student(String name) {
        this.name = name;
        this.counter++;
    }
}