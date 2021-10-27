package com.codingtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RobotTest {

    private static final int x = 2;
    private static final int y = 2;
    private final Grid grid = new Grid(4, 4);

    @ParameterizedTest
    @MethodSource("directions")
    void shouldTurnLeft(Orientation current, Position expected, Orientation expectedOrientation) {
        Robot robot = new Robot(new Position(x, y), current, grid);
        robot.moveForward();
        assertThat(robot.getCurrentPosition()).isEqualTo(expected);
        assertThat(robot.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    void shouldMarkAsLostIfGoneBeyondGrid() {
        Robot robot = new Robot(new Position(4, 4), Orientation.E, grid);
        robot.moveForward();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(5, 4));
        assertThat(robot.getOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.isLost()).isTrue();
    }

    @Test
    void shouldNotBeMarkedAsLostIfWellInsideTheGrid() {
        Robot robot = new Robot(new Position(2, 2), Orientation.E, grid);
        robot.moveForward();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(3, 2));
        assertThat(robot.getOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.isLost()).isFalse();
    }


    @Test
    void shouldNotBeMarkedAsLostIfOnEdgeOfTheGrid() {
        Robot robot = new Robot(new Position(3, 4), Orientation.E, grid);
        robot.moveForward();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(4, 4));
        assertThat(robot.getOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.isLost()).isFalse();
    }

    @ParameterizedTest
    @MethodSource("leftDirections")
    void shouldTurnLeft(Orientation current, Orientation expected) {
        Robot robot = new Robot(new Position(2, 2), current, new Grid(4, 4));
        robot.turnLeft();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(2, 2));
        assertThat(robot.getOrientation()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("rightDirections")
    void shouldTurnRight(Orientation current, Orientation expected) {
        Robot robot = new Robot(new Position(2, 2), current, new Grid(4, 4));
        robot.turnRight();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(2, 2));
        assertThat(robot.getOrientation()).isEqualTo(expected);
    }

    private static Stream<Arguments> rightDirections() {
        return Stream.of(
                Arguments.of(Orientation.N, Orientation.E),
                Arguments.of(Orientation.E, Orientation.S),
                Arguments.of(Orientation.S, Orientation.W),
                Arguments.of(Orientation.W, Orientation.N)
        );
    }

    private static Stream<Arguments> leftDirections() {
        return Stream.of(
                Arguments.of(Orientation.E, Orientation.N),
                Arguments.of(Orientation.N, Orientation.W),
                Arguments.of(Orientation.W, Orientation.S),
                Arguments.of(Orientation.S, Orientation.E)
        );
    }
    private static Stream<Arguments> directions() {
        return Stream.of(
                Arguments.of(Orientation.E, new Position(x + 1, y), Orientation.E),
                Arguments.of(Orientation.N, new Position(x, y + 1), Orientation.N),
                Arguments.of(Orientation.W, new Position(x - 1, y), Orientation.W),
                Arguments.of(Orientation.S, new Position(x, y - 1), Orientation.S)
        );
    }
}