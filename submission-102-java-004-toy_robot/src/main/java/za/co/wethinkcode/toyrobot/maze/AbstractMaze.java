package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMaze implements Maze{

    private List<Obstacle> obstacleList = new ArrayList<>();
    private List<Position> spaceList = new ArrayList<>();

    public void setObstacleList(List<Obstacle> list) {
        this.obstacleList = list;
    }

    public void setSpaceList(List<Position> spaceList2) {
        this.spaceList = spaceList2;
    }

    public List<Position> getSpace() {
        return spaceList;
    }

    @Override
    public List<Obstacle> getObstacles() {
        return obstacleList;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        return false;
    }

    public abstract void generateObstacles();

 // byte[][] grid = new byte[401][201]
 // 1,1 for 0..4 for 0..4 = 1 grid[y][x] == 1 = blocked
}
