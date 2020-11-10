import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GameParameterizedTest {

    static Game game = new Game();

    char letter;
    int attempt;
    int balance;

    public GameParameterizedTest(char letter, int attempt, int balance) {
        this.letter = letter;
        this.attempt = attempt;
        this.balance = balance;
    }

    @Parameterized.Parameters()
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {'a',1,5}, {'b',2,0}, {'c',3,-5}, {'p',4,5}
        });
    }

    @Test
    public void testBalanceAndAttemptsCheck(){
        game.startGame("apple", "description");

        game.openLetter(letter);
        assertEquals(balance, game.getBalance());
        assertEquals(attempt, game.getAttempts());
    }
}
