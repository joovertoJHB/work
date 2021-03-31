package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;

public abstract class Command {
    private final String name;
    private String argument;
    private static final ArrayList<String> mylist = new ArrayList<>();
    public static History history = new History(mylist);
    public static Replay switchOn = new Replay();
    public static ReplayReverseCommand switchOnReverse = new ReplayReverseCommand();
    
    public abstract boolean execute(Robot target);

    public Command(String name){
        this.name = name.trim().toLowerCase();
        this.argument = "";
    }  

    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim();
    }

    public String getName() {                                                                           
        return name;
    }

    public String getArgument() {
        return this.argument;
    }  

    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");

        switch (args[0]){
            case "shutdown":
            case "off":
            return new ShutdownCommand();
            case "help":
            return new HelpCommand();
            case "forward":
                if (!switchOn.getSwitch() && !switchOnReverse.getSwitch()) {history.addHistory(instruction);}
                return new ForwardCommand(args[1]);
            case "back":         
                if (!switchOn.getSwitch() && !switchOnReverse.getSwitch()) {history.addHistory(instruction);}
                return new BackCommand(args[1]);
            case "left":
                if (!switchOn.getSwitch() && !switchOnReverse.getSwitch()) {history.addHistory(instruction);}
                return new LeftCommand();
            case "right":
                if (!switchOn.getSwitch() && !switchOnReverse.getSwitch()) {history.addHistory(instruction);}
                return new RightCommand();
            case "sprint":
                if (!switchOn.getSwitch() && !switchOnReverse.getSwitch()) {history.addHistory(instruction);}
                return new SprintCommand(args[1]);
            case "replay":
                if (instruction.contains("reversed") && args.length == 2) {
                    return new ReplayReverseCommand();
                }
                if(args.length == 1){ return new Replay(); }
                if(args.length == 2){ return new Replay(args[1]); }
                if(args.length == 3){ return new ReplayReverseCommand(args[2]); }

            case "mazerun":
                return new MazeRunnerCommand();
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}

