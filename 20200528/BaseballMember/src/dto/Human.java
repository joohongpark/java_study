package dto;

public class Human {
    private String name;
    private int number;
    private int age;
    private double height;

    public Human(String name, int number, int age, double height) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "name : " + name + ", age : " + age + ", Number : " + number + ", height : " + height;
    }
}
