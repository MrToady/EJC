package task_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Creates Casino, implements user interaction
 */
public class Casino {
    private int betNumber;

    public Casino() {
        System.out.println(Text.CASINO_WELCOME);
        Player player = new Player();
        while (WantToPlayAgain()) {
            if (player.hasNoMoney()) {
                System.out.println(Text.CASINO_PLAYER_CANNOT_PLAY);
                return;
            }
            player.printBalance();
            takeBet();
            player.bet();
            Race race = new Race();
            if (race.getWinner() == betNumber) {
                System.out.println(Text.CASINO_PLAYER_WIN);
                player.win();
                player.printBalance();
            } else {
                System.out.println(Text.CASINO_PLAYER_LOSE);
                player.printBalance();
            }
        }
    }

    /**
     * Asks if user wants to start another iteration
     *
     * @return true or false
     */
    private boolean WantToPlayAgain() {
        System.out.println(Text.CASINO_PLAY_AGAIN);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String answer;
            try {
                answer = reader.readLine();
                switch (answer) {
                    case "y":
                        System.out.println(Text.CASINO_START);
                        return true;
                    case "n":
                        System.out.println(Text.CASINO_NO_START);
                        return false;
                    default:
                        System.out.println(Text.CASINO_WRONG_ANSWER);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Asks user number of duck to bet on
     * Writes it in Casino betNumber field
     */
    private void takeBet() {
        System.out.println(String.format(Text.CASINO_WANT_TO_BET, Modifier.NUM_OF_PATRICIPANTS));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean answerIsCorrect = false;
        while (!answerIsCorrect) {
            try {
                betNumber = Integer.parseInt(reader.readLine());
                if (betNumber <= 0 || betNumber > Modifier.NUM_OF_PATRICIPANTS)
                    System.out.println(String.format(Text.CASINO_WRONG_NUMBER, Modifier.NUM_OF_PATRICIPANTS));
                else {
                    System.out.println(String.format(Text.CASINO_YOUR_BET, betNumber));
                    answerIsCorrect = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println(Text.CASINO_NUMBER_FORMAT_EXCEPTION);
            }
        }
    }
}
