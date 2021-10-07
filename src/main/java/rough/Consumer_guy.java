package rough;

import java.util.ArrayList;

public class Consumer_guy extends Thread{
    ArrayList<Integer> sharedQueue;
    int max;
    boolean flag=true;
    Consumer_guy(ArrayList<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {

        while(true){
            try {
                System.out.println("---BBBBB------");

                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consume() throws InterruptedException {

        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) {
                System.out.println("queue is empty. wait for producer to produce element to the queue");
                sharedQueue.wait();
            }
            int x = sharedQueue.remove(0);
            System.out.println("item " + x + "is consumed...");
            Thread.sleep(10);
            sharedQueue.notifyAll();
//            Thread.sleep(1000);
            flag=false;

        }
    }
}
