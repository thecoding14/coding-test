package com.codingtest.commands;

import com.codingtest.Position;
import com.codingtest.Robot;

public class ForwardInstruction implements RobotInstruction {
    private final Robot robot;

    public ForwardInstruction(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Position execute() {
        robot.moveForward();
        return robot.getCurrentPosition();
    }
}
