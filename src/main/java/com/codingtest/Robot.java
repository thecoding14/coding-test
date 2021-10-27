package com.codingtest;

import java.util.Objects;
import java.util.UUID;

public class Robot {
    private String id = UUID.randomUUID().toString();
    private Position currentPosition;
    private Position previousPosition;
    private final Grid grid;
    private boolean isLost;
    private Orientation orientation;

    public Robot(Position currentPosition, Orientation orientation, Grid grid) {
        this.currentPosition = currentPosition;
        this.orientation = orientation;
        this.grid = grid;
    }

    public void turnLeft() {
        this.orientation = orientation.turnLeft();
    }

    public void turnRight() {
        this.orientation = orientation.turnRight();
    }

    public void moveForward() {
        Position nextPosition = orientation.getForwardFunction().apply(this.currentPosition);
        if(grid.isScented(currentPosition, this) && grid.isOutOfBounds(nextPosition)) {
            return;
        }
        this.previousPosition = this.currentPosition;
        this.currentPosition = nextPosition;
        if (!isLost && grid.isOutOfBounds(currentPosition)) {
            isLost = true;
            grid.addScented(this.previousPosition, this);
        }
    }


    public Position getCurrentPosition() {
        return currentPosition;
    }

    public boolean isLost() {
        return isLost;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;
        Robot robot = (Robot) o;
        return isLost() == robot.isLost() &&
                Objects.equals(id, robot.id) &&
                Objects.equals(getCurrentPosition(), robot.getCurrentPosition()) &&
                Objects.equals(previousPosition, robot.previousPosition) &&
                Objects.equals(grid, robot.grid) &&
                getOrientation() == robot.getOrientation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCurrentPosition(), previousPosition, grid, isLost(), getOrientation());
    }

    @Override
    public String toString() {
        return currentPosition + " " + orientation + (isLost ? " LOST" : "");
    }
}
