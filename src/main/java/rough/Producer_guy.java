package rough;

import java.util.ArrayList;

public class Producer_guy extends Thread{

    ArrayList<Integer> sharedQueue;
    int max;
    boolean flag=true;
    Producer_guy(ArrayList<Integer> sharedQueue,int MAX_LIMIT)
    {
        this.sharedQueue=sharedQueue;
        this.max=MAX_LIMIT;
    }
    @Override
    public void run() {
        int count=0;

        while(flag) {
            try {
                System.out.println("------AAA_____");

                produce(count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public  void produce(int count) throws InterruptedException {

        synchronized (sharedQueue) {
            if (sharedQueue.size() == max) {
                System.out.println("queue is full. wait for consumer to consume it");
                sharedQueue.wait();

            }
            System.out.println("produced.. " + count);
            sharedQueue.add(count);
            Thread.sleep(10);
            System.out.println("aaaa");
            sharedQueue.notifyAll();
            System.out.println("++++++");
            flag=false;
        }


    }
}
