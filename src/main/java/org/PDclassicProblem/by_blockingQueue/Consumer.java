package org.PDclassicProblem.by_blockingQueue;

import java.util.Queue;

public class Consumer<T extends Number> implements Runnable {
    private final CustomBlockingQueue<T> queue;

    public Consumer(CustomBlockingQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                T item = queue.take();
                // You can process item if needed
                Thread.sleep(1000); // simulate consumption delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
