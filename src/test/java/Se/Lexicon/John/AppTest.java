package Se.Lexicon.John;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

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
        assertEquals(actualCounter,expectedCounter,0);


    }

    @Test
    public void testAlreadyGuessedWord() {
        //Arrange
        testGame.setUserGuess("Pony");
        testGame.setGuessed("Pony");
        char[] word = testGame.getSecretWord().toCharArray();
        StringBuilder testGameGuessedd = testGame.getGuessed();
        int expectedIndex = 0;

        //Act
        testGame.evaluateWord(word);
        int actualIndex = testGame.(testGame.getUserGuess());

        //Assert
        assertEquals(actualIndex,expectedIndex,0);
    }
}

