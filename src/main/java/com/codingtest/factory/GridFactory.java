package com.codingtest.factory;

import com.codingtest.Grid;

public class GridFactory {
    public static final int MAX_COORDINATE = 50;

    public static Grid create(String grid) {
        try {
            String[] gridCoordinates = grid.split("\\s+");
            if (gridCoordinates.length < 2) {
                throw new RuntimeException();
            }
            int maxX = Integer.parseInt(gridCoordinates[0]);
            int maxY = Integer.parseInt(gridCoordinates[1]);
            if(maxX > MAX_COORDINATE || maxY > MAX_COORDINATE || maxX < 0 || maxY < 0) {
                throw new RuntimeException();
            }
            return new Grid(maxX, maxY);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Please enter valid values e.g. \"3 4\" (max : 50 50)");
        }
    }
}
