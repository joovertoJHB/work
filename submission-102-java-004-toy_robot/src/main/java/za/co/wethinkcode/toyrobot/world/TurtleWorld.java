package za.co.wethinkcode.toyrobot.world;

import org.turtle.StdDraw;
import org.turtle.Turtle;
import za.co.wethinkcode.toyrobot.maze.AbstractMaze;

import java.awt.*;
import java.util.List;

public class TurtleWorld extends AbstractWorld implements IWorld {

    private final Turtle turtle;
    private final Turtle obstacle;
    private final Turtle border;


    public TurtleWorld(AbstractMaze maze) {

        super(maze);
        this.turtle = new Turtle(0.0,0.0,90.0);
        this.turtleSetup();
        this.border = new Turtle(-100.0,200.0,90.0);
        this.makeBorder();
        this.obstacle = new Turtle(0.0,0.0,90.0);
        this.obstacleSetup();
        this.showObstacles();
        this.turtle.forward(0);

    }
    private void turtleSetup() {
        StdDraw.setXscale(-110, 110);
        StdDraw.setYscale(-210,210);
        this.turtle.setSize(1);
        this.turtle.show();
        this.turtle.setColor(Color.blue);
    }

    private void obstacleSetup() {
        this.obstacle.show();
        this.obstacle.setSize(0.010);
        this.obstacle.setColor(Color.black);
    }

    public void turtleGo(int x, int y){
        this.turtle.setColor(Color.blue);
        this.turtle.setPosition(x,y);
        this.turtle.forward(0.0);
    }

    public void turtleReset() {
        this.turtle.setColor(Color.white);
        this.turtle.forward(0.0);
    }

    public void turnTurtle(boolean turnRight) {
        if (turnRight) {
            this.turtle.right(90.0);
        } else {
            this.turtle.left(90.0);
        }
    }

    public void showObstacles() {
        List<Obstacle> obstacleList = this.getObstacles();
        for (Obstacle obstacle : obstacleList) {
            int x = obstacle.getBottomLeftX();
            int y = obstacle.getBottomLeftY();
            this.obstacle.setPosition(x, y);
            for (int z = 0; z < 4; z++) {
                this.obstacle.forward(2.0);
                this.obstacle.right(90.0);
            }
        }
    }

    public void makeBorder() {
        this.border.show();
        this.border.setSize(0.010);
        this.border.setColor(Color.blue);
        this.border.right(90.0);

        for (int i = 0; i < 2;i++) {
            this.border.forward(200.0);
            this.border.right(90.0);
            this.border.forward(400.0);
            this.border.right(90.0);

        }
    }
}