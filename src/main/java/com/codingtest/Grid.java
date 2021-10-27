package com.codingtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Grid {
    private int maxX;
    private int maxY;
    private Map<Position, Robot> scented = new HashMap<>();

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Map<Position, Robot> getScented() {
        return scented;
    }

    public void addScented(Position position, Robot robot) {
        scented.put(position, robot);
    }

    public boolean isScented(Position position, Robot robot) {
        return scented.containsKey(position) && !scented.get(position).equals(robot);
    }

    public boolean isOutOfBounds(Position pos) {
        return maxX < pos.getX() || maxY < pos.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grid)) return false;
        Grid grid = (Grid) o;
        return getMaxX() == grid.getMaxX() &&
                getMaxY() == grid.getMaxY() &&
                Objects.equals(getScented(), grid.getScented());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxX(), getMaxY(), getScented());
    }
}
