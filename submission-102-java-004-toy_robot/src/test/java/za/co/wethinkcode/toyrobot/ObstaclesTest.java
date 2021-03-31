package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import za.co.wethinkcode.toyrobot.world.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObstaclesTest {

    @Test
    void TestObsDimensions() {
        Obstacle obstacle = new SquareObstacle(7,6);
        assertEquals(7,obstacle.getBottomLeftX());
        assertEquals(6,obstacle.getBottomLeftY());
        assertEquals(5, obstacle.getSize());
    }

    @Test
    void BlockPosTrue() {
        Obstacle obstacle = new SquareObstacle(5,5);
        assertTrue(obstacle.blocksPosition(new Position(5,5)));
        assertTrue(obstacle.blocksPosition(new Position(9,5)));
        assertTrue(obstacle.blocksPosition(new Position(7,6)));
    }

    @Test
    void BlockPosFalse() {
        Obstacle obstacle = new SquareObstacle(0,5);
        assertFalse(obstacle.blocksPosition(new Position(5,5)));
        assertFalse(obstacle.blocksPosition(new Position(10,5)));
        assertFalse(obstacle.blocksPosition(new Position(7,6)));
    }

    @Test
    void BlockPathTrue() {
        Obstacle obstacle = new SquareObstacle(0,5);
        assertTrue(obstacle.blocksPath(new Position(1,0), new Position(1,7)));
        assertTrue(obstacle.blocksPath(new Position(1,-4), new Position(1,7)));
        assertTrue(obstacle.blocksPath(new Position(1,4), new Position(1,7)));

    }

    @Test
    void BlockPathFalse() {
        Obstacle obstacle = new SquareObstacle(0,5);
        assertFalse(obstacle.blocksPath(new Position(1,0), new Position(1,4)));
        assertFalse(obstacle.blocksPath(new Position(1,10), new Position(1,17)));
        assertFalse(obstacle.blocksPath(new Position(1,0), new Position(1,-7)));

    }
}
