package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.AbstractMaze;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorld implements IWorld {

    private final Position TOP_LEFT = new Position(-100,200);
    private final Position BOTTOM_RIGHT = new Position(100,-200);
    public List<Obstacle> obstaclesList = new ArrayList<>();

    public static final Position CENTRE = new Position(0,0);

    private Position position;
    private IWorld.Direction currentDirection;


    public AbstractWorld(AbstractMaze maze) {
        this.position = IWorld.CENTRE;
        this.currentDirection = IWorld.Direction.UP;
        this.obstaclesList = maze.getObstacles();
    }

    @Override
    public IWorld.UpdateResponse updatePosition(int nrSteps) {
        UpdateResponse response = UpdateResponse.SUCCESS;
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (IWorld.Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }

        if (IWorld.Direction.RIGHT.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }

        if (IWorld.Direction.LEFT.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        if (IWorld.Direction.DOWN.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }

        Position newPosition = new Position(newX, newY);

        if (!newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            return UpdateResponse.FAILED_OUTSIDE_WORLD;
        }

        for (Obstacle obs: obstaclesList) {
            if (obs.blocksPosition(newPosition) || (obs.blocksPath(this.position, newPosition))) {
                return IWorld.UpdateResponse.FAILED_OBSTRUCTED;
            }
        }
        
        this.position = newPosition;
        return UpdateResponse.SUCCESS;
    }

    @Override
    public void updateDirection(boolean turnRight) {
        if (turnRight) {
            if (this.currentDirection.equals(IWorld.Direction.UP)) {
                this.currentDirection = IWorld.Direction.RIGHT;
            } else if (this.currentDirection.equals(IWorld.Direction.RIGHT)) {
                this.currentDirection = IWorld.Direction.DOWN;
            } else if (this.currentDirection.equals(IWorld.Direction.DOWN)) {
                this.currentDirection = IWorld.Direction.LEFT;
            } else {
                this.currentDirection = IWorld.Direction.UP;
            }
            
        } else {
            if (this.currentDirection.equals(IWorld.Direction.UP)) {
                this.currentDirection = IWorld.Direction.LEFT;
            } else if (this.currentDirection.equals(IWorld.Direction.LEFT)) {
                this.currentDirection = IWorld.Direction.DOWN;
            } else if (this.currentDirection.equals(IWorld.Direction.DOWN)) {
                this.currentDirection = IWorld.Direction.RIGHT;
            } else {
                this.currentDirection = IWorld.Direction.UP;
            }
        }
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public IWorld.Direction getCurrentDirection() {
        return this.currentDirection;
    }

    @Override
    public boolean isNewPositionAllowed(Position position) {
        return position.isIn(TOP_LEFT, BOTTOM_RIGHT);
    }

    @Override
    public boolean isAtEdge() {
        if (this.position.getX() == 100 || this.position.getX() == -100) {
            return true;
        }

        if (this.position.getY() == 200 || this.position.getY() == -200) {
            return true;
        }

        return false;
    }

    @Override
    public void reset() {
        this.currentDirection = IWorld.Direction.UP;
        this.position = IWorld.CENTRE;
    }

    @Override
    public List<Obstacle> getObstacles() {
        return obstaclesList;
    }

    public void setObstaclesList(List<Obstacle> obstaclesList) {
        this.obstaclesList = obstaclesList;
    }

    @Override
    public void showObstacles() {

    }
}
