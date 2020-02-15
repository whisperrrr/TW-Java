public class Bird extends Animal {
    String flySpeed;

    public Bird() {
    }

    public Bird(int age, String weight, String flySpeed) {
        super(age, weight);
        this.flySpeed = flySpeed;
    }

    public void fly() {
        System.out.println("I am flying...");
    }
}
