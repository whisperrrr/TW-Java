package com;

public class West extends Direction {

    public West() {
        super('W');
    }

    @Override
    public Direction turnLeft() {
        return new North();
    }

    @Override
    public Direction turnRight() {
        return new South();
    }
}
