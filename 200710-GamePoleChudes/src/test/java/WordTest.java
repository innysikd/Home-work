import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    Word word = new Word("apple", "some description");

    @Test
    public void testGetWordWithStars() {
        assertEquals("*****", word.getWordWithStars());
    }

    @Test //lower, capital case, special symbols, cyrillic
    public void testOpenLetterValidChar() {
        word.openLetter('a');
        assertEquals("a****", word.getWordWithStars());

        word.openLetter('e');
        assertEquals("a***e", word.getWordWithStars());

        word.openLetter('E');
        assertEquals("a***e", word.getWordWithStars());
    }

    @Test //lower, capital case, special symbols, cyrillic
    public void testInvalidLetter() {

        word.openLetter('c');
        assertEquals("*****", word.getWordWithStars());

        word.openLetter('?');
        assertEquals("*****", word.getWordWithStars());

        word.openLetter('0');
        assertEquals("*****", word.getWordWithStars());
    }

    @Test //valid word
    public void testOpenWordValid() throws WrongWordLengthException {

        word.openWord("apple");
        assertTrue(true);
    }

    @Test //valid word
    public void testOpenWordInvalid() throws WrongWordLengthException {

        word.openWord("mommy");
        assertFalse(false);
    }

    @Test(expected = WrongWordLengthException.class) //invalid word length
    public void testOpenWordInvalidLength() throws WrongWordLengthException {

        word.openWord("coconut");
    }

    @Test
    public void isWin() throws WrongWordLengthException {

        word.openLetter('a');
        word.openLetter('p');
        word.openLetter('l');
        word.openLetter('e');

        assertTrue(word.isWin());
    }


}
