package za.co.wethinkcode.toyrobot.maze;

import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.toyrobot.world.AbstractWorld;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

public class SimpleMaze extends AbstractMaze implements Maze{

    private List<Obstacle> obstacleList = new ArrayList<>();

    public SimpleMaze(){
        this.generateObstacles();
        setObstacleList(this.obstacleList);

    }

    @Override
    public void generateObstacles() {
        Obstacle obstacle = new SquareObstacle(1, 1);
        this.obstacleList.add(obstacle);
    }
}
