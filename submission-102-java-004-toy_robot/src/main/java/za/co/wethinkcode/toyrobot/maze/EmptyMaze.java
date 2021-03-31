package za.co.wethinkcode.toyrobot.maze;

import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.toyrobot.world.Obstacle;

public class EmptyMaze extends AbstractMaze implements Maze{

    private final List<Obstacle> obstaclesList = new ArrayList<>();

    public EmptyMaze() {
        this.generateObstacles();
        setObstacleList(obstaclesList);
    }

    @Override
    public void generateObstacles() {
        obstaclesList.clear();
    }
}
