package org.example.java8_plus.methods;

import java.util.List;

public class RunnableExample {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(" Old legacy runnable ");
        }
    };

    Runnable newRunnable = () -> System.out.println("By lamda expression");

    public void runnableUser() throws InterruptedException {
        Thread thread = new Thread(() -> runnable.run());
        Thread newRunnableThread = new Thread(() -> newRunnable.run());

        thread.start();
        newRunnableThread.start();

        thread.join();
        newRunnableThread.join();
    }

}
