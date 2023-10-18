package org.example.practice.concurrency;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ProducerService {
    private SharedResource sharedResource;
    private Random random;

    public ProducerService(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
        this.random = new Random();
    }

    public void statProducing(int count, int waitTime) {
        Thread thread = new Thread(getProducerRunnable(count, waitTime));
        thread.start();
    }

    public Runnable getProducerRunnable(int count, int waitTime) {

        return () ->
                IntStream.iterate(0, i -> i + 1)
                         .limit(count)
                         .map(index -> waitTime)
                         .boxed()
                         .forEach(getIntegerConsumer());
    }

    private Consumer<Integer> getIntegerConsumer() {
        return gap -> {
            try {
                int item = random.nextInt(20);
                sharedResource.produce(item);
                long millis = random.nextLong(gap);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
