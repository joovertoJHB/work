package za.co.wethinkcode.toyrobot;

import java.util.List;
import java.util.Collections;

public class ReplayReverseCommand extends Command {

    Command command;

    private static boolean switchOnReverse = false;
    public static History historyList = new History(history.getHistory());

    private String argument = getArgument();

    public boolean getSwitch() {
        return ReplayReverseCommand.switchOnReverse;
    }
    public void setSwitchOn(boolean switchOn) { ReplayReverseCommand.switchOnReverse = switchOn; }

    @Override
    public boolean execute(Robot target) {

        List<String> listHistory = historyList.getHistory();
        setSwitchOn(true);

        if (argument.equals("")) {
            for (int x = listHistory.size()-1; x>=0;x--) {
                command = Command.create(listHistory.get(x));
                target.handleCommand(command);
                target.showStatus(target);
            }

        }  else if (argument.contains("-")) {
            Collections.reverse(listHistory);
            String[] args = this.argument.trim().split("-");

            int highNumber = Integer.parseInt(args[0]);
            int lowNumber = Integer.parseInt(args[1]);

            for(int x = highNumber-1; x > lowNumber; x--) {
                command = Command.create(listHistory.get(x));
                target.handleCommand(command);
                target.showStatus(target);
            }

        } else {
            int argumentInt = Integer.parseInt(argument);
            for (int x = 0; x <= argumentInt-1; x++) {
                command = Command.create(listHistory.get(x));
                target.handleCommand(command);
                target.showStatus(target);
            }
        }

        target.setStatus("replayed "+historyList.getHistory().size()+" commands");
        historyList.getHistory().clear();
        setSwitchOn(false);
        return true;
    }

    public ReplayReverseCommand() {
        super("replay");
    }

    public ReplayReverseCommand(String argument) {
        super("replay", argument);
        this.argument = argument;
    }
}
