package comnew;

public class Car{
    private Direction curDirection;

    public Car(Direction curDirection) {
        this.curDirection = curDirection;
    }

    public void turnLeft() {
        Direction curDirection = this.curDirection.turnLeft();
        System.out.println(curDirection);
    }

    public void turnRight() {
        Direction curDirection = this.curDirection.turnRight();
        System.out.println(curDirection);
    }
}
