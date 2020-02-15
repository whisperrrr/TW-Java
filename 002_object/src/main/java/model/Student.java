package model;

public class Student {
    private String name;
    private int age;
    private String gender;
    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //Getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    //全参数构造
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //成员函数
    public void study() {
        System.out.println("I am studying");
    }

    public void sleep() {
        System.out.println("I am sleeping");
    }
}
