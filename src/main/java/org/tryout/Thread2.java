package org.tryout;


import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Thread2 extends Thread {

    private ReentrantLock lock;

    Thread2(ReentrantLock x) {
        this.lock = x;
    }

    @Override
    public void run() {

        if (lock.tryLock()) {
            lock.lock();


            IntStream.range(0, 7).forEach((idx) -> {
                System.out.println(idx + "thread 2");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("releasing the lock - thread2");
            lock.unlock();

        }
        else{
            System.out.println("run this method, inside Thread2 as unable to get hold of lock");
        }
    }


}
