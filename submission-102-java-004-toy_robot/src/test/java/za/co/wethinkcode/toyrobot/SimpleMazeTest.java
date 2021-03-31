package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.maze.Maze;
import za.co.wethinkcode.toyrobot.maze.SimpleMaze;

import za.co.wethinkcode.toyrobot.world.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMazeTest {

    @Test
    void testSimpleMazeHasOne() {
        Maze maze = new SimpleMaze();
        assertEquals(1, maze.getObstacles().size());
        assertTrue(maze.getObstacles().get(0).blocksPosition(new Position(5,5)));
    }
}
