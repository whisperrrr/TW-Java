public class Eagle extends Bird{
    String preyObject;

    public Eagle() {
    }

    public Eagle(int age, String weight, String flySpeed, String preyObject) {
        super(age, weight, flySpeed);
        this.preyObject = preyObject;
    }

    public void prey() {
        System.out.println("I am hungry");
        System.out.println("I will prey some " + this.preyObject);
    }
}
