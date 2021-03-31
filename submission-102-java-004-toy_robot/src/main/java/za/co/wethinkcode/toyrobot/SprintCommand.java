package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {

    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        int count = nrSteps;

        for (int x = 0; x < count; x++) {
            if (target.updatePosition(nrSteps)) {
                target.setStatus("Moved forward by "+nrSteps+ " steps.");
                if (nrSteps > 1) {
                    target.showStatus(target);
                }
            } else {
                target.setStatus("Sorry, I cannot go outside my safe zone.");
                break;
            }
            nrSteps--;
        }
        return true;
    }

    public SprintCommand(String argument) {
        super("Sprint", argument);
    }
}
