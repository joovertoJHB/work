package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Text;

import za.co.wethinkcode.toyrobot.maze.*;
import za.co.wethinkcode.toyrobot.world.*;

public class Play {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        Robot robot;

        
        String name = getInput("What do you want to name your robot?");
        robot = new Robot(name);

        // check argument imports
        
        if (args.length == 0) { Text(robot, new EmptyMaze());System.out.println("Loaded EmptyMaze");}

        else if (args[0].equalsIgnoreCase("text") ) {
            if (args.length == 1 || args[1].equalsIgnoreCase("emptymaze")) {Text(robot, new EmptyMaze());System.out.println("Loaded EmptyMaze");}
            else if (args[1].equalsIgnoreCase("designedmaze")) { Text(robot, new DesignedMaze());System.out.println("Loaded DesignedMaze");}
            else if (args[1].equalsIgnoreCase("randommaze")) {Text(robot, new RandomMaze());System.out.println("Loaded RandomMaze");}
            else if (args[1].equalsIgnoreCase("simplemaze")) {Text(robot, new SimpleMaze());System.out.println("Loaded SimpleMaze");}
        } else if (args[0].equalsIgnoreCase("turtle")) {
            if (args.length == 1 || args[1].equalsIgnoreCase("emptymaze")) {Text(robot, new EmptyMaze());System.out.println("Loaded EmptyMaze");}
            else if (args[1].equalsIgnoreCase("designedmaze")) { Turtle(robot, new DesignedMaze());System.out.println("Loaded DesignedMaze");}
            else if (args[1].equalsIgnoreCase("randommaze")) {Turtle(robot, new RandomMaze());System.out.println("Loaded RandomMaze");}
            else if (args[1].equalsIgnoreCase("simplemaze")) {Turtle(robot, new SimpleMaze());System.out.println("Loaded SimpleMaze");}
        }

        System.out.println("Hello Kiddo!");

        System.out.println(robot.toString());

        Command command;
        boolean shouldContinue = true;
        do {
            String instruction = getInput(robot.getName() + "> What must I do next?").strip().toLowerCase();
            try {
                command = Command.create(instruction);
                shouldContinue = robot.handleCommand(command);
            } catch (IllegalArgumentException e) {
                robot.setStatus("Sorry, I did not understand '" + instruction + "'.");
            }
            System.out.println(robot);
        } while (shouldContinue);
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        while (input.isBlank()) {
            System.out.println(prompt);
            input = scanner.nextLine();
        }
        return input;
    }
    private static void Text(Robot robot, AbstractMaze maze){
        robot.makeTextWorld(new TextWorld(maze));
    }
    private static void Turtle(Robot robot, AbstractMaze maze){robot.makeTurtleWorld(new TurtleWorld(maze));}
}
