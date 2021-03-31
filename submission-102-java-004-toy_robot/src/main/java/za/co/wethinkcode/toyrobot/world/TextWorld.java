package za.co.wethinkcode.toyrobot.world;

import java.util.List;

import za.co.wethinkcode.toyrobot.maze.AbstractMaze;
import za.co.wethinkcode.toyrobot.maze.SimpleMaze;

public class TextWorld extends AbstractWorld implements IWorld{

    public TextWorld(AbstractMaze maze) {
        super(maze);
        this.showObstacles();
    }

    public void showObstacles() {
        List<Obstacle> obstacleList = this.getObstacles();
        System.out.println("There are some obstacles:");
        for (int i = 0;i < obstacleList.size(); i++) {
            Obstacle obs = obstacleList.get(i);
            int xCord = obs.getBottomLeftX();
            int yCord = obs.getBottomLeftY();
            System.out.println("- At position "+xCord+","+yCord+" (to "+(xCord + 4)+","+(yCord+4)+")");
        }   
    }
}
