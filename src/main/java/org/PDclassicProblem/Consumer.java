package org.PDclassicProblem;

import java.util.LinkedList;
import java.util.List;

//consumer thread
public class Consumer<T> extends Thread {

    private final List<Integer> taskQueue;

    Consumer(List<Integer> taskQueue) {
        this.taskQueue = taskQueue;

    }

    @Override
    public void run() {

        while (true) {
            try {
                consume();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (taskQueue) {

            while(taskQueue.isEmpty()){
                System.out.println("taskQueue is empty..wait for adding items");
                taskQueue.wait();
            }
            Thread.sleep(100);
           int removal= taskQueue.remove(0);
            System.out.println("consumed.. "+removal);
            taskQueue.notifyAll();


        }
    }
}
