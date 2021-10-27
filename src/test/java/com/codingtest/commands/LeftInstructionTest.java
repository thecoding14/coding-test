package com.codingtest.commands;

import com.codingtest.Orientation;
import com.codingtest.Position;
import com.codingtest.Robot;
import com.codingtest.Grid;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LeftInstructionTest {

    @ParameterizedTest
    @MethodSource("directions")
    void shouldTurnLeft(Orientation current, Orientation expected) {
        Robot robot = new Robot(new Position(2, 2), current, new Grid(4, 4));
        new LeftInstruction(robot).execute();
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(2, 2));
        assertThat(robot.getOrientation()).isEqualTo(expected);
    }

    private static Stream<Arguments> directions() {
        return Stream.of(
                Arguments.of(Orientation.E, Orientation.N),
                Arguments.of(Orientation.N, Orientation.W),
                Arguments.of(Orientation.W, Orientation.S),
                Arguments.of(Orientation.S, Orientation.E)

        );
    }

}