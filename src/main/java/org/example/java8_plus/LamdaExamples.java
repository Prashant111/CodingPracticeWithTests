package org.example.java8_plus;

public class LamdaExamples {
    public void lamda1Example() {
        Runnable threadFromLegacyWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread from legacy way");
            }
        };
        Thread legacyThread = new Thread(threadFromLegacyWay);
        legacyThread.start();

        Runnable threadFromNewWay = () -> System.out.println("Thread from new way");
        Thread newWay = new Thread(threadFromNewWay);
        newWay.start();
    }
}
