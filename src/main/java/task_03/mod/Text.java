package task_03.mod;

import java.util.HashMap;

/**
 * Class for storing text messages
 */
public class Text {
    public static final String GAME_WELCOME = "Hello! This is a three-dimensional \"Battle Ship\".\n" +
            "Ten ships are arranged on a three-dimensional field of 6x6x6 points.\n" +
            "One battleship,\n" +
            "Two cruisers,\n" +
            "Three submarines,\n" +
            "And four destroyers.\n\n" +
            "The ships are placed in a random order. " +
            "Two players participate. Each player enters the coordinates of his shot from the console\n" +
            "The winner is the one who first strikes all the enemy ships. Good luck!";
    public static final String GAME_PLAY_AGAIN = "Want to play? (y/n): ";
    public static final String GAME_START = "Let's start a new round!";
    public static final String GAME_NO_START = "Game over.";
    public static final String GAME_WRONG_ANSWER = "Enter 'y' for a positive answer or 'n' for a negative";
    public static final String GAME_COORDINATE = "Enter the coordinate of the shot by ";
    public static final String GAME_NUMBER_FORMAT = "Enter the coordinate correctly.";
    public static final String GAME_WRONG_NUMBER = "Enter the number between 0 and %d";
    public static final String GAME_WRONG_POINT = "You have already shot this point.";
    public static final String GAME_INJURED = "Hit!";
    public static final String GAME_KILLED = "Hit! Ship sank.";
    public static final String FAIL = "Miss.";
    public static final String WIN = "All enemy ships were destroyed. You won!";
    public static final String FIRST_PLAYER_MOVE = "\nThe first player's turn";
    public static final String SECOND_PLAYER_MOVE = "\nThe second player's turn";
    public static final HashMap<Integer, String> DECKS = new HashMap<>();

    static {
        DECKS.put(4, "battleship. \n");
        DECKS.put(3, "cruiser. \n");
        DECKS.put(2, "submarine. \n");
        DECKS.put(1, "destroyer. \n");
    }
}
