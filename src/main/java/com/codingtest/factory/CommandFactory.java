package com.codingtest.factory;

import com.codingtest.Robot;
import com.codingtest.commands.ForwardInstruction;
import com.codingtest.commands.LeftInstruction;
import com.codingtest.commands.RightInstruction;
import com.codingtest.commands.RobotInstruction;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class CommandFactory {
    private static Map<Character, Function<Robot, RobotInstruction>> commands = Map.of(
            'L', LeftInstruction::new,
            'R', RightInstruction::new,
            'F', ForwardInstruction::new
    );

    public static RobotInstruction getRobotInstruction(Character command, Robot robot) {
        return Optional.ofNullable(commands.get(command))
                .orElseThrow(IllegalArgumentException::new)
                .apply(robot);
    }
}
