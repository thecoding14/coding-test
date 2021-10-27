package com.codingtest.factory;

import com.codingtest.Grid;
import com.codingtest.Orientation;
import com.codingtest.Position;
import com.codingtest.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codingtest.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

class RobotFactoryTest {
    private static Grid grid = GridFactory.create("50 50");

    @ParameterizedTest
    @MethodSource("invalidCommands")
    void shouldNotAcceptInvalidPositionParams(String command) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> RobotFactory.create(command, grid));
    }

    @ParameterizedTest
    @MethodSource("validCommands")
    void shouldCreateRobotWithValidValues(String command, Robot expected) {
        Robot actual = RobotFactory.create(command, grid);
        assertThat(actual.getOrientation()).isEqualTo(expected.getOrientation());
        assertThat(actual.getCurrentPosition()).isEqualTo(expected.getCurrentPosition());
    }

    private static Stream<Arguments> invalidCommands() {
        return Stream.of(
                Arguments.of("5 5 L"),
                Arguments.of("E 5 5"),
                Arguments.of("5"),
                Arguments.of("5 5"),
                Arguments.of("E W N"),
                Arguments.of("-1 -1 E")
        );
    }

    private static Stream<Arguments> validCommands() {
        grid = GridFactory.create("50 50");
        return Stream.of(
                Arguments.of("50 50 E", new Robot(new Position(50, 50), E, grid)),
                Arguments.of("1 1 S", new Robot(new Position(1, 1), S, grid)),
                Arguments.of("5 5 W", new Robot(new Position(5, 5), W, grid))
        );
    }
}