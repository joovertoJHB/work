package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import za.co.wethinkcode.toyrobot.maze.EmptyMaze;
import za.co.wethinkcode.toyrobot.maze.SimpleMaze;
import za.co.wethinkcode.toyrobot.world.*;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractWorldTest {

    @Test
    void ChangeDirectionLeft() {
        IWorld world = new TextWorld(new EmptyMaze());
        world.updateDirection(true);
        assertEquals(IWorld.Direction.RIGHT, world.getCurrentDirection());
        world.updatePosition(100);
        Position newPosition = new Position(IWorld.CENTRE.getX() + 100, IWorld.CENTRE.getY());
        assertEquals(newPosition, world.getPosition());
    }

    @Test
    void MoveForward() {
        IWorld world = new TextWorld(new EmptyMaze());
        world.updatePosition(10);
        Position newPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY()+10);
        assertEquals(newPosition, world.getPosition());
    }

    @Test
    void MoveBack() {
        IWorld world = new TextWorld(new EmptyMaze());
        world.updatePosition(-10);
        Position newPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY()-10);
        assertEquals(newPosition, world.getPosition());
    }

    @Test
     void isNewPositionAllowed() {
         IWorld world = new TextWorld(new SimpleMaze());
         assertTrue(world.isNewPositionAllowed(new Position(100,0)));
         assertTrue(world.isNewPositionAllowed(new Position(100,100)));
         assertFalse(world.isNewPositionAllowed(new Position(201,0)));
         assertFalse(world.isNewPositionAllowed(new Position(0,201)));
     }
}
