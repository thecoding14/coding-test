package com.codingtest;

import java.util.function.Function;

public enum Orientation {
    N(pos -> new Position(pos.getX(), pos.getY() + 1)),
    E(pos -> new Position(pos.getX() + 1, pos.getY())),
    S(pos -> new Position(pos.getX(), pos.getY() - 1)),
    W(pos -> new Position(pos.getX() - 1, pos.getY()));

    private Function<Position, Position> forwardFunction;

    private static Orientation[] values = values();

    Orientation(Function<Position, Position> forwardFunction) {
        this.forwardFunction = forwardFunction;
    }

    public Orientation turnRight() {
        return values[(ordinal() + 1) % values.length];
    }

    public Orientation turnLeft() {
        return values[(ordinal() - 1 + values.length) % values.length];
    }

    public Function<Position, Position> getForwardFunction() {
        return forwardFunction;
    }
}
