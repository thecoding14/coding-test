package com.codingtest;

import com.codingtest.commands.RobotInstruction;
import com.codingtest.factory.CommandFactory;

public class InstructionExecutor {
    public Position executeInstructions(String instructions, Robot robot) {
        return instructions.chars()
                .mapToObj(c -> CommandFactory.getRobotInstruction((char) c, robot))
                .map(RobotInstruction::execute)
                .reduce((a, b) -> b).orElse(null);
    }
}
