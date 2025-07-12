package org.PDclassicProblem.by_blockingQueue;

public class ThreadBlockingQueueDemo {
    public static void main(String[] args) {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(16);
        ItemGenerator<Integer> intGenerator = new ItemGenerator<Integer>() {
            private int counter = 0;

            @Override
            public Integer generate() {
                return counter++;
            }
        };

        Thread t1 = new Thread(new Producer(queue,intGenerator));
        Thread t2 = new Thread(new Consumer(queue));
        t1.start();
        t2.start();
    }
}
