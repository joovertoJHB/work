package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaze extends AbstractMaze implements Maze{

    private final List<Obstacle> obstaclesList = new ArrayList<>();

    public RandomMaze() {
        this.generateObstacles();
        setObstacleList(this.obstaclesList);
    }

    @Override
    public void generateObstacles() {
        Random random = new Random();
        int randNum = random.nextInt(9) + 1;

        for (int i =1; i <= randNum;i++) {
            int x = random.nextInt(100 + 100) - 100;
            int y = random.nextInt(200+200) - 200;
            Obstacle obstacle = new SquareObstacle(x, y);
            this.obstaclesList.add(obstacle);
        }
    }
}
