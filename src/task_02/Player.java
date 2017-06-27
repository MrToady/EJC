package task_02;

class Player {
    private int cash = Modifier.START_CASH;

    void win() {
        cash += Modifier.WIN_CASH;
    }

    void bet() {
        cash -= Modifier.BET_CASH;
    }

    boolean isEmpty() {
        return cash <= 0;
    }

    void printBalance() {
        System.out.println(String.format(Text.PLAYER_BALANCE, cash));
    }
}
