package com.codingtest.commands;

import com.codingtest.Position;
import com.codingtest.Robot;

public class RightInstruction implements RobotInstruction {
    private final Robot robot;

    public RightInstruction(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Position execute() {
        robot.turnRight();
        return robot.getCurrentPosition();
    }
}
