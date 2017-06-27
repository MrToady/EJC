package task_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Casino {

    int betNumber;

    public Casino() {
        System.out.println(Text.CASINO_WELCOME);
        startPlay();
    }

    private void startPlay(){
        Player player = new Player();
        while (WantToPlayAgain()) {
            if (player.isEmpty()) {
                System.out.println(Text.CASINO_PLAYER_CANNOT_PLAY);
                return;
            }
            player.printBalance();
            acceptABet();
            player.bet();
            Race race = new Race();
            if (race.getWinner() == betNumber) {
                System.out.println(Text.CASINO_PLAYER_WIN);
                player.win();
                player.printBalance();
            }
            else {
                System.out.println(Text.CASINO_PLAYER_LOSE);
                player.printBalance();
            }
        }
    }


    private void acceptABet() {
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
                    //reader.close();
                    answerIsCorrect = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println(Text.CASINO_NUMBER_FORMAT_EXCEPTION);
            }
        }
    }


    public boolean WantToPlayAgain() {
        System.out.println(Text.CASINO_PLAY_AGAIN);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String answer;
            try {
                answer = reader.readLine();
                switch (answer) {
                    case "д":
                        System.out.println(Text.CASINO_START);
                        //reader.close();
                        return true;
                    case "н":
                        System.out.println(Text.CASINO_NO_START);
                        //reader.close();
                        return false;
                    default:
                        System.out.println(Text.CASINO_WRONG_ANSWER);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
