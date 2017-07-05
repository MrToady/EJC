package task_03.game;

import task_03.battlefield.Field;
import task_03.mod.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Creates two players with their battlefields
 * Starts new game
 */
public class Game {
    public Game() {
        System.out.println(Text.GAME_WELCOME);
        while (wantToPlayAgain()) {
            Player player1 = new Player(new Field());
            Player player2 = new Player(new Field());
            while (true) {
                System.out.println(Text.FIRST_PLAYER_MOVE);
                player2.getField()
                        .addShot(player1.shot());
                if (player2.allKilled()) {
                    System.out.println(Text.WIN);
                    break;
                }

                System.out.println(Text.SECOND_PLAYER_MOVE);
                player1.getField()
                        .addShot(player2.shot());
                if (player1.allKilled()) {
                    System.out.println(Text.WIN);
                    break;
                }
            }
        }
    }

    /**
     * Asks if users want to start another iteration
     *
     * @return true or false
     */
    private static boolean wantToPlayAgain() {
        System.out.print(Text.GAME_PLAY_AGAIN);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String answer;
            try {
                answer = reader.readLine();
                switch (answer) {
                    case "д":
                        System.out.println(Text.GAME_START);
                        return true;
                    case "н":
                        System.out.println(Text.GAME_NO_START);
                        return false;
                    default:
                        System.out.println(Text.GAME_WRONG_ANSWER);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
