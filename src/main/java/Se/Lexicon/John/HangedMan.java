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
    private boolean GameOver = false;


    //Getters and Setters
    public String[] getSecretWordBank() { return secretWordBank; }
    public int getNumberOfGuesses() { return numberOfGuesses; }
    public void setNumberOfGuesses (int numberOfGuesses) { this.numberOfGuesses = numberOfGuesses;}
    public String getSecretWord() { return secretWord; }
    public void setSecretWord (String secretWord) { this.secretWord = secretWord;}
    public String getUserGuess() {return userGuess;}
    public void setUserGuess (String userGuess) { this.userGuess = userGuess;}
    public int getIndexofGuessed (String userGuess) {return guessed.indexOf(userGuess);}
    public StringBuilder getGuessed () {return guessed;}
    public void setGuessed (String userGuess) { guessed.append(userGuess);}
    public boolean isGameOver() {return GameOver;}

    //Constructor
    public HangedMan(int numberOfGuesses, String secretWord, String userGuess, StringBuilder guessed) {
        this.numberOfGuesses = numberOfGuesses;
        this.secretWord = secretWord;
        this.userGuess = userGuess;
        this.guessed = guessed;
    }

    public HangedMan() {}

    //Initiates a new game by picking a random word
    public void newGame() {
        int rng = ThreadLocalRandom.current().nextInt(0, 10);
        secretWord = secretWordBank[rng];
        char [] word = secretWord.toCharArray();
        char [] guess = new char[word.length];
        System.out.println("");
        Arrays.fill(guess, '_');
        makeGuess(guess, word);
    }

    //Base method for making a guess
    public void makeGuess(char[] guess, char[] word) {
        while (!GameOver) {
            if (numberOfGuesses >= 8) {
            printGallows();
            looseGame();
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
                } else if (userGuess.length() > 1) {
                    evaluateWord(word);
                } else {
                    evaluateLetter(guess, word);
                }
            }
        }
    }

    //Evaluates a whole word guess
    public void evaluateWord(char[] word) {
        printGallows();
        if (userGuess.equalsIgnoreCase(secretWord)) {
            for (int i = 0; i < word.length; i++) {
                System.out.print(word[i]);
                System.out.print(" ");
            }
            winGame();
        } else if  (guessed.indexOf(userGuess)>-1) {
            System.out.println("You already guessed that word!");
        } else {
            numberOfGuesses++;
            System.out.println("Sorry that was wrong!");
            guessed.append(userGuess);
            guessed.append(" ");
        }
    }

    //Evaluates a single letter guess
    public void evaluateLetter(char[] guess, char[] word) {
        boolean[] present = new boolean[word.length];
        if  (guessed.indexOf(userGuess)>-1) {
                System.out.println("You already guessed that letter!");
        }
        for (int i=0; i<word.length;) {
            if (userGuess.charAt(0) == word[i]) {
                guess[i] = word[i];
                present[i] = true;
                i++;
            }
            else {
                guess[i] = guess[i];
                present[i] = false;
                i++;
            }
        }
        if (containsAnyTrues(present)){
            guessed.append(userGuess);
            guessed.append(" ");
        }
        else {
            numberOfGuesses++;
            guessed.append(userGuess);
            guessed.append(" ");
        }
    }

    //Ascii graphic representing the number of tries left
    public void printGallows() {
        System.out.println("/..HangeMan v0.1..\\");
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
                break;
        }
    }


    public boolean containsAnyTrues(boolean[] present) {
        for (boolean num : present) {
            if (num) {
                return true;
            }
        }
        return false;
    }

    //Winner winner chicken dinner!
    public void winGame() {
        System.out.println();
        System.out.println("Correct! You won!");
        GameOver = true;
    }

    //User is a LOOSER
    public void looseGame() {
        System.out.println();
        System.out.println("You LOOSE! You're hanged!");
        GameOver =true;
    }
}






