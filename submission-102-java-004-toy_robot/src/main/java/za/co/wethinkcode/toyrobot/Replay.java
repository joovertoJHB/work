package za.co.wethinkcode.toyrobot;

import java.util.*;

public class Replay extends Command {

    Command command;

    private static boolean switchOn = false;
    public static History historyList = new History(history.getHistory());
    private String argument = "";
    private int replayAmmount = 0;

    public boolean getSwitch() {
        return Replay.switchOn;
    }
    public void setSwitchOn(boolean switchOn) {
        Replay.switchOn = switchOn;
    }

    @Override
    public boolean execute(Robot target) {   

        setSwitchOn(true);
        
        if (argument.equals("")) {
            for (String s: historyList.getHistory()) {
                command = Command.create(s);
                target.handleCommand(command);
                this.replayAmmount++;
                target.showStatus(target);
            }

        } else if (argument.contains("-")) {
            List<String> listHistory = historyList.getHistory();
            String[] args = this.argument.trim().split("-");
            Collections.reverse(listHistory);

            int highNumber = Integer.parseInt(args[0]);
            int lowNumber = Integer.parseInt(args[1]);

            for(int x = highNumber-1; x >= lowNumber; x--) {
                command = Command.create(listHistory.get(x));
                target.handleCommand(command);
                this.replayAmmount++;
                target.showStatus(target);
            }

        } else {
            int argumentInt = Integer.parseInt(argument);
            List<String> listHistory = historyList.getHistory();

            for (int x = 1; x <= argumentInt; x++) {
                command = Command.create(listHistory.get(x));
                target.handleCommand(command);
                this.replayAmmount++;
                target.showStatus(target);
            }
        }

        target.setStatus("replayed "+replayAmmount+" commands.");
        historyList.getHistory().clear();
        this.replayAmmount = 0;
        setSwitchOn(false);
        return true;
    }

    public Replay() {
        super("replay");
    }

    public Replay(String argument) {
        super("replay", argument);
        this.argument = argument;
    }
}