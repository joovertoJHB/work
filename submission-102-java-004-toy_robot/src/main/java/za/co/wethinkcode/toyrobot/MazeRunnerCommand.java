package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.maze.MazeRunner;
import za.co.wethinkcode.toyrobot.maze.SimpleMazeRunner;
import za.co.wethinkcode.toyrobot.world.IWorld;

public class MazeRunnerCommand extends Command{

    @Override
    public boolean execute(Robot target) {
        MazeRunner mazeObj = new SimpleMazeRunner(target, IWorld.Direction.UP);
        target.setStatus("Starting mazerun...");
        mazeObj.mazeRun(target, IWorld.Direction.UP);
        return true;
    }

    public MazeRunnerCommand() {
        super("mazerun");
    }
}
