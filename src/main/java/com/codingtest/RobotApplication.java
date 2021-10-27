package com.codingtest;

import com.codingtest.factory.GridFactory;
import com.codingtest.factory.RobotFactory;

import java.util.Scanner;

public class RobotApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InstructionExecutor instructionExecutor = new InstructionExecutor();
        while (true) {
            try {
                System.out.println("Enter World Dimensions:");
                String maxCoordinates = scanner.nextLine();
                Grid grid = GridFactory.create(maxCoordinates);

                while (true) {
                    try {
                        System.out.println("Enter Robot Position:");
                        String robotPosition = scanner.nextLine();
                        Robot robot = RobotFactory.create(robotPosition, grid);

                        System.out.println("Enter Robot Instructions:");
                        String instructions = scanner.nextLine();
                        instructionExecutor.executeInstructions(instructions, robot);

                        System.out.println(robot);
                    } catch (Throwable e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
