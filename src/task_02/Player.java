package task_02;

public class Player {
    /**
     * Contains player's balance
     */
    private int cash = Modifier.START_CASH;

    public void win() {
        cash += Modifier.WIN_CASH;
    }

    public void bet() {
        cash -= Modifier.BET_CASH;
    }

    public boolean hasNoMoney() {
        return cash < Modifier.BET_CASH;
    }

    public void printBalance() {
        System.out.println(String.format(Text.PLAYER_BALANCE, cash));
    }
}
