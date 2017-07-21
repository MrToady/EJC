package task_05;

import java.io.IOException;

/**
 * Creates two threads
 *
 * @see ThreadFlagSetter
 * @see ThreadRabbitEatsCarrot
 */
public class Rabbit {
    private volatile static boolean enterWasntPressed = true;

    public static void main(String[] args) {
        new Rabbit.ThreadRabbitEatsCarrot().start();
        new Rabbit.ThreadFlagSetter().start();
    }

    /**
     * Switches the flag value to "false" after pressing "Enter"
     */
    private static class ThreadFlagSetter extends Thread {
        @Override
        public void run() {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            enterWasntPressed = false;
        }
    }

    /**
     * Prints "I'm eating carrot." until {@code flag} is {@code true}.
     */
    private static class ThreadRabbitEatsCarrot extends Thread {
        @Override
        public void run() {
            while (enterWasntPressed) {
                System.err.println("I'm eating carrot.");
            }
        }
    }
}
