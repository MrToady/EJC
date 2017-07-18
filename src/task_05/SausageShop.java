package task_05;

public class SausageShop {
    private static int sausageAmount = 50;

    public static void main(String[] args) {
        createSausageBuyers(7);
    }

    /**
     * Creates specified number of buyers threads.
     *
     * @param buyersAmount threads amount.
     */
    private static void createSausageBuyers(int buyersAmount) {
        for (int i = 0; i < buyersAmount; i++) {
            new Thread(() -> buySausage(10)).start();
        }
    }

    /**
     * If requested sausage amount is less or equal than {@code sausageAmount}
     * reduces {@code sausageAmount} value
     *
     * @param requestedSausage sausage to buy
     */
    private synchronized static void buySausage(int requestedSausage) {
        if (requestedSausage <= sausageAmount) {
            sausageAmount -= requestedSausage;
            System.err.println(Thread.currentThread().getName() + ". Remaining sausages: " + sausageAmount);
        } else {
            System.err.println(Thread.currentThread().getName() + ". Not enough sausages to sell");
        }
    }
}
