package org.PDclassicProblem.by_blockingQueue;

import java.util.Queue;

public class Producer<T extends Number> implements Runnable {
    private final CustomBlockingQueue<T> queue;
    private final ItemGenerator<T> itemGenerator;

    public Producer(CustomBlockingQueue<T> queue, ItemGenerator<T> itemGenerator) {
        this.itemGenerator = itemGenerator;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                T item=itemGenerator.generate();
                queue.put(item);


            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
