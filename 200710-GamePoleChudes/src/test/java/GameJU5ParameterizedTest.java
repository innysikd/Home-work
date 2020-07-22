import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameJU5ParameterizedTest {

    static Game game = new Game();

    @ParameterizedTest
    @MethodSource("providesLetterBalanceAndAttempt")
    public void testBalanceAndAttemptsCheck(char letter, int attempt, int balance){
        game.startGame("apple", "description");

        game.openLetter(letter);
        assertEquals(balance, game.getBalance());
        assertEquals(attempt, game.getAttempts());
    }

    private static Stream<Arguments> providesLetterBalanceAndAttempt() {
        return Stream.of(
                Arguments.of('a',1,5),
                Arguments.of('b',2,0),
                Arguments.of('c',3,-5),
                Arguments.of('p',4,5)
        );
    }
}
