public class Animal {
    int age;
    String weight;

    public Animal() {
    }

    public Animal(int age, String weight) {
        this.age = age;
        this.weight = weight;
    }

    public void eat() {
        System.out.println("eating...");
    }

    public void sleep() {
        System.out.println("I am tired");
        System.out.println("Sleeping...");
    }
}
