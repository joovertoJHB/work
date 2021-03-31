package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.world.*;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    public static final Position CENTRE = new Position(0,0);


    private Position position;
    private IWorld.Direction currentDirection;
    private String status;
    private AbstractWorld abstractWorld;
    private String name;
    private TextWorld textWorld;
    private TurtleWorld turtleWorld;
    private boolean turtleOn = false;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = IWorld.Direction.UP;
    }

    public void makeTextWorld(TextWorld world) {
        this.textWorld = world;
        abstractWorld = this.textWorld;
        this.turtleOn = false;
    }

    public void makeTurtleWorld(TurtleWorld world) {
        this.turtleWorld = world;
        abstractWorld = this.turtleWorld;
        this.turtleOn = true;
    }

    public String getStatus() {
        return this.status;
    }

    public IWorld.Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps){
        IWorld.UpdateResponse move = abstractWorld.updatePosition(nrSteps);

        switch (move) {
            case SUCCESS:
                if (turtleOn) {
                    turtleWorld.turtleReset();
                    turtleWorld.turtleGo(abstractWorld.getPosition().getX(), abstractWorld.getPosition().getY());
                }
                this.position = abstractWorld.getPosition();
                return true;
            case FAILED_OBSTRUCTED:
                setStatus("Sorry, there is an obstacle in the way.");
                return false;
            case FAILED_OUTSIDE_WORLD:
                setStatus("Sorry, I cannot go outside my safe zone.");
                return false;
        }
        return true;
    }

    public void updateDirection(boolean turnRight) {
        abstractWorld.updateDirection(turnRight);
        if (turtleOn){turtleWorld.turnTurtle(turnRight);}
        this.currentDirection = abstractWorld.getCurrentDirection();
    }

    @Override
    public String toString() {
       return "[" + this.abstractWorld.getPosition().getX() + "," + this.abstractWorld.getPosition().getY() + "] "
               + this.name + "> " + this.status;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void showStatus(Robot robot) {
        System.out.print(robot+"\n");
    }
    public void setCurrentDirection(IWorld.Direction direction) { this.currentDirection = direction; }
}