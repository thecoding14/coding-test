package com.codingtest.factory;

import com.codingtest.Grid;
import com.codingtest.Position;
import com.codingtest.Robot;
import com.codingtest.commands.ForwardInstruction;
import com.codingtest.commands.LeftInstruction;
import com.codingtest.commands.RightInstruction;
import com.codingtest.factory.CommandFactory;
import com.codingtest.factory.GridFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codingtest.Orientation.E;
import static org.assertj.core.api.Assertions.assertThat;

class CommandFactoryTest {

    private final Position position = new Position(0, 0);
    private final Grid grid = GridFactory.create("10 20");

    @ParameterizedTest
    @MethodSource("commandAndExpectedClass")
    void shouldReturnAppropriateCommand(char command, Class instance) {
        assertThat(CommandFactory.getRobotInstruction(command, new Robot(position, E, grid))).isInstanceOf(instance);
    }

    private static Stream<Arguments> commandAndExpectedClass() {
        return Stream.of(
                Arguments.of('L', LeftInstruction.class),
                Arguments.of('R', RightInstruction.class),
                Arguments.of('F', ForwardInstruction.class)
        );
    }
}