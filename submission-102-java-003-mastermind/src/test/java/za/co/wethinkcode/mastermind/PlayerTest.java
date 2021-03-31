package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.mastermind.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testLongReturn() {
    Player player = new Player(new ByteArrayInputStream("12356\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
    }

    @Test
    public void testEmptyReturn() {
    Player player = new Player(new ByteArrayInputStream("\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
    }

    @Test
    public void testCharReturn() {
    Player player = new Player(new ByteArrayInputStream("123e\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
    }

    @Test
    public void testShortReturn() {
    Player player = new Player(new ByteArrayInputStream("123\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
    }

    @Test
    public void test9Return() {
    Player player = new Player(new ByteArrayInputStream("1239\n1230\n1234\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("1234", guess);
    }
}
