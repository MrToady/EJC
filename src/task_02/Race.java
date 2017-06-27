package task_02;

import java.util.ArrayList;

public class Race {
    private ArrayList<Duck> ducks;
    private boolean raceIsFihished = false;
    private int winnerNum;

    private void createRace() {
        boolean everybodyIsShot = true;
        while (everybodyIsShot) {
            ducks = new ArrayList<>();
            for (int i = 0; i < Modifier.NUM_OF_PATRICIPANTS; i++) {
                if (Math.random() > Modifier.POSS_OF_SHOT_DUCK) {
                    ducks.add(new HealthyDuck());
                    everybodyIsShot = false;
                } else ducks.add(new ShotDuck());
            }
        }
    }

    public void start() {
        createRace();
        System.out.println(Text.RACE_WELCOME);
        for (int i = 0; i < Modifier.NUM_OF_PATRICIPANTS; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(String.format(Text.RASER_NUMBER, i + 1) + " ");
            ducks.get(i).Display();
        }

        for (String command : new String[]{Text.RACERS_IS_READY, Text.READY, Text.STEADY, Text.GO}
                ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(command);
        }

        while (!raceIsFihished) {
            for (int i = 0; i < Modifier.NUM_OF_PATRICIPANTS; i++) {
                int flewInThisSecond = ducks.get(i).performFly();
                ducks.get(i).addToDoneDistanse(flewInThisSecond);
                System.out.println(String.format(Text.SITUATION, i + 1, ducks.get(i).getDoneDistanсe()));
                if (ducks.get(i).isFinished()) {
                    System.out.println(String.format(Text.IS_WINNER, i + 1));
                    raceIsFihished = true;
                    winnerNum = i + 1;
                    break;
                }
            }

            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getWinnerNum() {
        return winnerNum;
    }
}
