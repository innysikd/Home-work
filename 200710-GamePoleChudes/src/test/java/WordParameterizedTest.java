import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class WordParameterizedTest {

    static Word word = new Word("apple", "some description");
    char input;
    String expected;

    public WordParameterizedTest(char input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters()
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {'a',"a****"}, {'e',"a***e"}, {'E', "a***e"}, {'c', "a***e"}, {'?', "a***e"}, {'p', "app*e"}
        });
    }

    @Test
    public void testOpenLetter() {
        word.openLetter(input);
        assertEquals(expected, word.getWordWithStars());
    }

}
