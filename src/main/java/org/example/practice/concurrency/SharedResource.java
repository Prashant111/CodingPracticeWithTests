package org.example.practice.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    public final int BUFFER_SIZE = 10;
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    private List<Integer> sharedList;

    public SharedResource() {
        sharedList = new ArrayList<>();
    }

    public void produce(int produced) throws InterruptedException {
        lock.lock();
        try {
            while (sharedList.size() == BUFFER_SIZE) {
                notFull.await();
            }
            sharedList.add(produced);
            System.out.println();
            System.out.println("produced = " + produced);
            System.out.println("sharedList = " + sharedList);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Integer consume() throws InterruptedException {
        lock.lock();
        try {
            while (sharedList.isEmpty()) {
                notEmpty.await();
            }
            int consumed = sharedList.remove(sharedList.size() - 1);
            System.out.println();
            System.out.println("consumed = " + consumed);
            System.out.println("sharedList = " + sharedList);
            notFull.signal();
            return consumed;
        } finally {
            lock.unlock();
        }
    }

}
