import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordJU5ParameterizedTest {

    static Word word = new Word("apple", "some description");

    @ParameterizedTest
    @MethodSource("providesLetterAndWord")
    public void testOpenLetter(char input, String expected) {
        word.openLetter(input);
        assertEquals(expected, word.getWordWithStars());
    }

    private static Stream<Arguments> providesLetterAndWord (){
        return Stream.of(
                Arguments.of('a',"a****"),
                Arguments.of('e',"a***e"),
                Arguments.of('E', "a***e"),
                Arguments.of('c', "a***e"),
                Arguments.of('?', "a***e"),
                Arguments.of('p', "app*e")
        );
    }


}
