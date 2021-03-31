package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import za.co.wethinkcode.toyrobot.maze.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyMazeTest {

    @Test
    void testEmptyMazeIsEmpty() {
        Maze maze = new EmptyMaze();
        assertEquals(0, maze.getObstacles().size());
    }
}
