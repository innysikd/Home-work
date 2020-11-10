import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game = new Game();

    @Before
    public void init() {
        game.startGame("procrastination", "description");
    }

    @Test
    public void startGame() {
        assertEquals(0, game.getAttempts());
        assertEquals(0, game.getBalance());
    }

    @Test
    public void attemptsCheck() throws WrongWordLengthException {
        game.openLetter('a');
        assertEquals(1, game.getAttempts());

        game.openLetter('a');
        assertEquals(2, game.getAttempts());

        game.openLetter('b');
        assertEquals(3, game.getAttempts());

        game.openWord("procrastenation");
        assertEquals(4, game.getAttempts());
    }

    @Test
    public void gameOverTest() throws WrongWordLengthException {
        game.openLetter('a');
        assertEquals(1, game.getAttempts());
        assertEquals(10, game.getBalance());

        game.openLetter('b');
        assertEquals(2, game.getAttempts());
        assertEquals(5, game.getBalance());

        game.openLetter('c');
        assertEquals(3, game.getAttempts());
        assertEquals(10, game.getBalance());

        game.openWord("procrastenation");
        assertEquals(4, game.getAttempts());
        assertEquals(-15, game.getBalance());

        game.openWord("procrastonation");
        assertEquals(5, game.getAttempts());
        assertEquals(-40, game.getBalance());

        game.openWord("procrastenation");
        assertEquals(5, game.getAttempts());
        assertEquals(-40, game.getBalance());
    }

    @Test
    public void balanceCheck() throws WrongWordLengthException {
        game.openLetter('a');
        assertEquals(10, game.getBalance());

        game.openLetter('b');
        assertEquals(5, game.getBalance());

        game.openWord("procrastonation");
        assertEquals(-20, game.getBalance());

        game.openWord("procrastination");
        assertEquals(30, game.getBalance());
    }

}
