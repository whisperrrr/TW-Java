package com;

public class North extends Direction {

    public North() {
        super('N');
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public Direction turnRight() {
        return new West();
    }
}