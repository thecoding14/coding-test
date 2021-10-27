package com.codingtest;

import com.codingtest.factory.GridFactory;
import com.codingtest.factory.RobotFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionExecutorTest {

    private Grid grid = GridFactory.create("5 3");
    private InstructionExecutor instructionExecutor = new InstructionExecutor();

    @Test
    void shouldMoveFromStartToCorrectEnd() {
        Robot robot = RobotFactory.create("1 1 E", grid);
        String instruction = "RFRFRFRF";
        instructionExecutor.executeInstructions(instruction, robot);
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(1, 1));
        assertThat(robot.getOrientation()).isEqualTo(Orientation.E);
        assertThat(robot.isLost()).isFalse();
    }


    @Test
    void shouldBeLost() {
        Robot robot = RobotFactory.create("3 2 N", grid);
        String instruction = "FRRFLLFFRRFLL";
        instructionExecutor.executeInstructions(instruction, robot);
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(3, 3));
        assertThat(robot.getOrientation()).isEqualTo(Orientation.N);
        assertThat(robot.isLost()).isTrue();
    }

    @Test
    void shouldIgnoreInstructions() {
        Robot robot = RobotFactory.create("3 2 N", grid);
        String instruction = "FRRFLLFFRRFLL";
        instructionExecutor.executeInstructions(instruction, robot);
        assertThat(robot.getCurrentPosition()).isEqualTo(new Position(3, 3));
        assertThat(robot.getOrientation()).isEqualTo(Orientation.N);
        assertThat(robot.isLost()).isTrue();

        Robot robot2 = RobotFactory.create("0 3 W", grid);
        String instruction2 = "LLFFFLFLFL";
        instructionExecutor.executeInstructions(instruction2, robot2);
        assertThat(robot2.getCurrentPosition()).isEqualTo(new Position(2, 3));
        assertThat(robot2.getOrientation()).isEqualTo(Orientation.S);
        assertThat(robot2.isLost()).isFalse();
    }

}