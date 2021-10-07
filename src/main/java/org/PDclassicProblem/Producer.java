package org.PDclassicProblem;

import java.util.List;

public class Producer<T> extends Thread {

    private final List<Integer> taskQueue;
    private final int Max_CAPACITY;

    public Producer(List<Integer> taskQueue,int size) {
        this.taskQueue = taskQueue;
        this.Max_CAPACITY=size;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                produce(count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(int i) throws InterruptedException {

        synchronized (taskQueue){
            while(taskQueue.size()==Max_CAPACITY){
                System.out.println("taskQueue is full wait some time for removal");
                taskQueue.wait();
            }

            Thread.sleep(100);
            taskQueue.add(i);

            System.out.println("produced "+i);
            taskQueue.notifyAll();
        }
    }
}
