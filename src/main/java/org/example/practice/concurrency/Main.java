package org.example.practice.concurrency;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ProducerService producerService = new ProducerService(sharedResource);
        ConsumerService consumerService = new ConsumerService(sharedResource);

        producerService.statProducing(100, 1000);
        consumerService.startConsuming(100, 2000);
    }
}
