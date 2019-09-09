package Se.Lexicon.John;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AppTest {
    private HangedMan testGame = new HangedMan();

    @Before
    public void setup() {
        testGame.setNumberOfGuesses(0);
        testGame.setSecretWord("Test");
    }

    @Test
    public void testGuessRightWord_AssertWin() {
        //Arrange
        testGame.setUserGuess("Test");
        char[] word = testGame.getSecretWord().toCharArray();

        //Act
        testGame.evaluateWord(word);
        boolean win = testGame.isGameOver();

        //Assert
        assertTrue(win);

    }

    @Test
    public void testGuessWrongWord() {
        //Arrange
        testGame.setUserGuess("Pony");
        char[] word = testGame.getSecretWord().toCharArray();
        int expectedCounter = 1;

        //Act
        testGame.evaluateWord(word);
        boolean win = testGame.isGameOver();
        int actualCounter = testGame.getNumberOfGuesses();

        //Assert
        assertFalse(win);
        assertEquals(actualCounter,expectedCounter);


    }

    @Test
    public void testAlreadyGuessedWord() {
        //Arange
        testGame.setUserGuess("Pony");
        testGame.setGuessed("Pony");
        char[] word = testGame.getSecretWord().toCharArray();
        int expectedIndex =0;
        int expectedCounter = 0;

        //Act
        testGame.evaluateWord(word);
        int actualIndex = testGame.getIndexofGuessed(testGame.getUserGuess());
        int actualCounter = testGame.getNumberOfGuesses();

        //Assert
        assertEquals(actualIndex,expectedIndex);
        assertEquals(actualCounter,expectedCounter);
    }

    @Test
    public void testRightLetter() {
        //Arange
        testGame.setUserGuess("e");
        char[] word = testGame.getSecretWord().toCharArray();
        char [] guess = new char[word.length];
        int expectedCounter = 0;
        char expectedIndex = testGame.getUserGuess().charAt(0);

        //Act
        testGame.evaluateLetter(guess, word);
        char actualIndex = word[1];
        int actualCounter = testGame.getNumberOfGuesses();

        //Assert
        assertEquals(actualCounter,expectedCounter);
        assertEquals(actualIndex,expectedIndex);
    }

    @Test
    public void testWrongLetter() {
        //
        testGame.setUserGuess("a");
        char[] word = testGame.getSecretWord().toCharArray();
        char [] guess = new char[word.length];
        int expectedCounter = 1;
        char expectedIndex = testGame.getUserGuess().charAt(0);

        //Act
        testGame.evaluateLetter(guess, word);
        char actualIndex = word[0];
        char actualIndex2 = word[1];
        char actualIndex3 = word[2];
        char actualIndex4 = word[3];
        int actualCounter = testGame.getNumberOfGuesses();

        //Assert
        assertEquals(actualCounter,expectedCounter);
        assertNotEquals(actualIndex,expectedIndex);
        assertNotEquals(actualIndex2,expectedIndex);
        assertNotEquals(actualIndex3,expectedIndex);
        assertNotEquals(actualIndex4,expectedIndex);

    }

    @Test
    public void testAlreadyGuessedLetter() {
        //Arange
        testGame.setUserGuess("l");
        testGame.setGuessed("l");
        char[] word = testGame.getSecretWord().toCharArray();
        char [] guess = new char[word.length];
        int expectedIndex =0;
        int expectedCounter = 1;

        //Act
        testGame.evaluateLetter(guess,word);
        int actualIndex = testGame.getIndexofGuessed(testGame.getUserGuess());
        int actualCounter = testGame.getNumberOfGuesses();

        //Assert
        assertEquals(actualIndex,expectedIndex);
        assertEquals(actualCounter,expectedCounter);
    }
}


