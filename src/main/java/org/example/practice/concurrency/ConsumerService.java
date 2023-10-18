package org.example.practice.concurrency;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConsumerService {
    private SharedResource sharedResource;
    private Random random;

    public ConsumerService(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.random = new Random();
    }

    public void startConsuming(int count, int waitTime) {
        Thread thread = new Thread(gerConsumerRunnable(count, waitTime));
        thread.start();
    }

    public Runnable gerConsumerRunnable(int count, int waitTime) {

        return () ->
                IntStream.iterate(0, i -> i + 1)
                         .limit(count)
                         .boxed()
                         .mapToInt(index -> waitTime)
                         .boxed()
                         .forEach(consumeSingleValue());
    }

    private Consumer<Integer> consumeSingleValue() {
        return gap -> {
            try {
                sharedResource.consume();
                Thread.sleep(random.nextInt(gap) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }


}
