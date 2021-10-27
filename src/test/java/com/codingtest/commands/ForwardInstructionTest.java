package com.codingtest.commands;

import com.codingtest.Orientation;
import com.codingtest.Grid;
import com.codingtest.Position;
import com.codingtest.Robot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codingtest.Orientation.E;
import static org.assertj.core.api.Assertions.assertThat;

class ForwardInstructionTest {

    private static int x = 2;
    private static int y = 2;
    private Grid grid = new Grid(4, 4);

    @ParameterizedTest
    @MethodSource("directions")
    void shouldTurnLeft(Orientation current, Position expected) {
        Robot robot = new Robot(new Position(x, y), current, grid);
        new ForwardInstruction(robot).execute();
        assertThat(robot.getCurrentPosition()).isEqualTo(expected);
    }

    @Test
    void shouldMarkAsLostIfGoneBeyondGrid() {
        Robot robot = new Robot(new Position(4, 4), E, grid);
        new ForwardInstruction(robot).execute();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(5, 4));
        assertThat(robot.getOrientation()).isEqualTo(E);
        assertThat(robot.isLost()).isTrue();
    }

    @Test
    void shouldNotBeMarkedAsLostIfWellInsideTheGrid() {
        Robot robot = new Robot(new Position(2, 2), E, grid);
        new ForwardInstruction(robot).execute();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(3, 2));
        assertThat(robot.getOrientation()).isEqualTo(E);
        assertThat(robot.isLost()).isFalse();
    }


    @Test
    void shouldNotBeMarkedAsLostIfOnEdgeOfTheGrid() {
        Robot robot = new Robot(new Position(3, 4), E, grid);
        new ForwardInstruction(robot).execute();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(4, 4));
        assertThat(robot.getOrientation()).isEqualTo(E);
        assertThat(robot.isLost()).isFalse();
    }

    private static Stream<Arguments> directions() {
        return Stream.of(
                Arguments.of(E, new Position(x + 1, y)),
                Arguments.of(Orientation.N, new Position(x, y + 1)),
                Arguments.of(Orientation.W, new Position(x - 1, y)),
                Arguments.of(Orientation.S, new Position(x, y - 1))
        );
    }

}