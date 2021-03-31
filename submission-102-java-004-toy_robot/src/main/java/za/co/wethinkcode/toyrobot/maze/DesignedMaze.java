package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;

public class DesignedMaze extends AbstractMaze implements Maze{

    private final List<Obstacle> obstaclesList = new ArrayList<>();
    private final List<Position> spaceList = new ArrayList<>();


    public DesignedMaze() {
        this.generateObstacles();
        setSpaceList(spaceList);
        setObstacleList(obstaclesList);
    }

    private final String[] maze = new String[]{
            "XXX  XXXXXXXXXXXXXXXXXXXX",
            "XXX  XXX             XXXX",
            "XXX  XXX  XXXXXXXXX  XXXX",
            "XXX  XXX  XXXXXXXXX  XXXX",
            "XXX       XXXXXXXXX  XXXX",
            "XXXXXXXX  XXXXXXXXX  XXXX",
            "XXXXXXXX  XXXXXXXXX  XXXX",
            "XXXXX                XXXX",
            "XXXXX  XXXXXXXXXXXXXXXXXX",
            "XXXXX  XXXXX           XX",
            "XXXXX  XXXXX  XX  XXX  XX",
            "XXXXX  XXXXX  XX  XXX    ",
            "XXXXX             XXX  XX",
            "    X         XXXXXXX  XX",
            "XX  X  XXXXX           XX",
            "XX  X  XXXXX  XX   XXXXXX",
            "XX  X  XXXXX  XX   XXXXXX",
            "XX     XXXXX  XX   XXXXXX",
            "XX  XXXXXXXX  XXX  XXXXXX",
            "XX  XXXXXXXX  XXX        ",
            "XX  XXXXXXXX  XXX  X  XXX",
            "XX  XXXXXXXX  XXX  X  XXX",
            "XX  XXXXXXXX  XXX  X  XXX",
            "XX                 X  XXX",
            "XXXXXXXX  XXXXXXXXXX  XXX",
    };

    @Override
    public void generateObstacles() {
        for (int i = 0; i < maze.length;i++){
            for(int f = 0; f < maze[i].length(); f++) {
                char characterI = maze[i].charAt(f);
                String X = String.valueOf(characterI);

                int screen_x = -96 + (f * 8);
                int screen_y = 196 - (i * 16);

                if (X.equals("X")) {
                    Obstacle obstacle = new SquareObstacle(screen_x,screen_y);
                    Obstacle obstacle1 = new SquareObstacle(screen_x,screen_y-4);
                    Obstacle obstacle2 = new SquareObstacle(screen_x,screen_y+4);
                    Obstacle obstacle3 = new SquareObstacle(screen_x,screen_y-8);
                    Obstacle obstacle4 = new SquareObstacle(screen_x-4,screen_y);

                    this.obstaclesList.add(obstacle);
                    this.obstaclesList.add(obstacle1);
                    this.obstaclesList.add(obstacle2);
                    this.obstaclesList.add(obstacle3);
                    this.obstaclesList.add(obstacle4);

                }

                if (X.equals(" ")) {
                    Position space = new Position(screen_x,screen_y);
                    this.spaceList.add(space);
                }
            }
        }
    }
}
