package com.codingtest.commands;

import com.codingtest.Position;
import com.codingtest.Robot;

public class LeftInstruction implements RobotInstruction {
    private final Robot robot;

    public LeftInstruction(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Position execute() {
        robot.turnLeft();
        return robot.getCurrentPosition();
    }
}
