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

class RightInstructionTest {

    @ParameterizedTest
    @MethodSource("directions")
    void shouldTurnRight(Orientation current, Orientation expected) {
        Robot robot = new Robot(new Position(2, 2), current, new Grid(4, 4));
        new RightInstruction(robot).execute();
        assertThat(robot.getOrientation()).isEqualTo(expected);
    }

    private static Stream<Arguments> directions() {
        return Stream.of(
                Arguments.of(Orientation.N, Orientation.E),
                Arguments.of(Orientation.E, Orientation.S),
                Arguments.of(Orientation.S, Orientation.W),
                Arguments.of(Orientation.W, Orientation.N)

        );
    }

}