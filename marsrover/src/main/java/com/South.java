package com;

public class South extends Direction {

    public South() {
        super('S');
    }

    @Override
    public Direction turnLeft() {
        return new West();
    }

    @Override
    public Direction turnRight() {
        return new East();
    }
}
