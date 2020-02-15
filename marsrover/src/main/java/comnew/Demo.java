package comnew;
/*
* 用枚举重构
* */
public class Demo {
    public static void main(String[] args) {
        Car car = new Car(Direction.East);

        car.turnLeft();
        car.turnRight();
    }
}
