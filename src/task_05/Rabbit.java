package task_05;

import java.io.IOException;

/**
 * Многопоточное приложение в котором кролик ест морковку
 * пока пользователь не введет какой-нибудь символ с консоли.
 */
public class Rabbit {
    public volatile static boolean flag = true;

    public static void main(String[] args) {
        new Rabbit.ThreadRabbitEatsCarrot().start();
        new Rabbit.ThreadFlagSetter().start();
    }

    public static class ThreadFlagSetter extends Thread {
        @Override
        public void run() {
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            flag = false;
        }
    }

    public static class ThreadRabbitEatsCarrot extends Thread {
        @Override
        public void run() {
            while (flag) {
                System.err.println("I'm eating carrot.");
            }
        }
    }
}
