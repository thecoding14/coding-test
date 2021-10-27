package com.codingtest.factory;

import com.codingtest.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GridFactoryTest {

    @ParameterizedTest
    @MethodSource("invalidCommands")
    void shouldNotAcceptInvalidGridParams(String command) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> GridFactory.create(command));
    }

    @ParameterizedTest
    @MethodSource("validCommands")
    void shouldCreateGridWithValidValues(String command, Grid expected) {
        assertThat(GridFactory.create(command)).isEqualTo(expected);
    }

    private static Stream<Arguments> invalidCommands() {
        return Stream.of(
                Arguments.of("50 51"),
                Arguments.of("51 50"),
                Arguments.of("5"),
                Arguments.of("a b"),
                Arguments.of(""),
                Arguments.of("-1 -1")
        );
    }

    private static Stream<Arguments> validCommands() {
        return Stream.of(
                Arguments.of("50 50", new Grid(50, 50)),
                Arguments.of("1 1", new Grid(1, 1)),
                Arguments.of("5 5", new Grid(5 ,5 ))
        );
    }
}