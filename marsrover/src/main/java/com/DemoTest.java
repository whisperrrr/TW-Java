package com;

public class DemoTest {
    public static void main(String[] args) {
        Direction direction = new East();
        direction.turnLeft().getDirection();

        System.out.println(direction.turnLeft().getDirection());
    }
}
