package Se.Lexicon.John;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.lang.String;

public class HangedMan {
    private static Scanner scanner = new Scanner(System.in);
    private int numberOfGuesses = 0;
    private String secretWord;
    private String[] secretWordBank = {"Door", "Horse", "Football", "Beer", "Refreshing", "Shower", "Stadium", "Lemon", "Strawberry", "Cloudberry"};
    private String userGuess;
    private StringBuilder guessed = new StringBuilder();

    //Initiates a new game by picking a random word
    public void newGame() {
        int rng = ThreadLocalRandom.current().nextInt(0, 10);
        secretWord = secretWordBank[rng];
        char[] word = secretWord.toCharArray();
        char[] guess = new char[word.length];
        System.out.println("");
        Arrays.fill(guess, '_');
        makeGuess(guess, word);
    }

    //Base method for making a guess
    public void makeGuess(char[] guess, char[] word) {
        if (numberOfGuesses >= 8) {
            printGallows();
        }
        else {
            printGallows();
            for (int i = 0; i < guess.length; i++) {
                System.out.print(guess[i]);
                System.out.print(" ");
        }
        System.out.println();
        System.out.println("Guesses: " + guessed);
        System.out.print("Make a guess (letter or word, case sensitive): ");
        userGuess = scanner.nextLine();
            if (userGuess.length() < 1) {
                System.out.println("That was not a valid guess!");
                makeGuess(guess, word);
            } else if (userGuess.length() > 1) {
                evaluateWord(guess, word);
            } else {
                evaluateLetter(guess, word);
            }
        }
    }

    //Evaluates a whole word guess
    public void evaluateWord(char[] guess, char[] word) {
        if (userGuess.equalsIgnoreCase(secretWord)) {
            printGallows();
            for (int i = 0; i < word.length; i++) {
                System.out.print(word[i]);
                System.out.print(" ");
            }
            winGame();
        } else if  (guessed.indexOf(userGuess)>-1) {
            System.out.println("You already guessed that word!");
            makeGuess(guess, word);
        } else {
            numberOfGuesses++;
            System.out.println("Sorry that was wrong!");
            guessed.append(userGuess);
            guessed.append(" ");
            makeGuess(guess, word);
        }
    }

    //Evaluates a single letter guess
    public void evaluateLetter(char[] guess, char[] word) {
        if  (guessed.indexOf(userGuess)>-1) {
                System.out.println("You already guessed that letter!");
                makeGuess(guess, word);
        }
        for (int i=0; i<word.length;) {
            if (userGuess.charAt(0) == word[i]) {
                guess[i] = word[i];
                i++;
            }
            else {
                guess[i] = guess[i];
                i++;
            }
        }
        numberOfGuesses++;
        guessed.append(userGuess);
        guessed.append(" ");
        makeGuess(guess, word);
    }

    //Ascii graphic representing the number of tries left
    public void printGallows() {
        System.out.println("/..Hanged Man v0.1..\\");
        switch (numberOfGuesses) {
            case 0:
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("       ");
                break;
            case 1:
                System.out.println("");
                System.out.println("_______");
                System.out.println("     \\|");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 2:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 3:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println(" 0    |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 4:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println(" 0    |");
                System.out.println("/     |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 5:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println(" 0    |");
                System.out.println("/|    |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 6:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println(" 0    |");
                System.out.println("/|\\   |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 7:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println(" 0    |");
                System.out.println("/|\\   |");
                System.out.println("/     |");
                System.out.println("      |");
                break;
            case 8:
                System.out.println("");
                System.out.println("_______");
                System.out.println(" |   \\|");
                System.out.println(" 0    |");
                System.out.println("/|\\   |");
                System.out.println("/ \\   |");
                System.out.println("      |");
                looseGame();
                break;
        }
    }

    //Winner winner chicken dinner!
    public void winGame() {
        System.out.println();
        System.out.println("Correct! You won!");
    }

    //User is a LOOSER
    public void looseGame() {
        System.out.println();
        System.out.println("You LOOSE! You're hanged!");
    }
}






