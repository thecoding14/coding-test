package com.codingtest.factory;

import com.codingtest.Grid;
import com.codingtest.Orientation;
import com.codingtest.Position;
import com.codingtest.Robot;

import java.util.Arrays;

import static com.codingtest.util.Utils.isPositiveNumber;
import static java.lang.Integer.parseInt;

public class RobotFactory {
    public static Robot create(String robotPosition, Grid grid) {
        String[] components = robotPosition.split("\\s+");
        if (components.length != 3 || !isPositiveNumber(components[0]) || !isPositiveNumber(components[1])) {
            throw new IllegalArgumentException("Incorrect position entered. Required format:  {x} {y} {orientation}, "
                    + "e.g.: \"3 4 N\"");
        }
        Position initialPosition = new Position(parseInt(components[0]), parseInt(components[1]));

        return new Robot(initialPosition,Orientation.valueOf(components[2]), grid);
    }
}
