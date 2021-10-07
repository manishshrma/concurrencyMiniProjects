package org.tryout;

import com.sun.security.jgss.GSSUtil;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Thread1 extends Thread {
    private ReentrantLock l;

    Thread1(ReentrantLock x) {
        this.l = x;
    }

    @Override
    public void run() {
        if(l.tryLock()) {
            IntStream.range(0, 7).forEach((idx) -> {
                System.out.println(idx + "thread 1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("releasing the lock-thread1");
            l.unlock();
        }
        else{
            System.out.println("unable to hold the lock as already acquired so run this else Thread-1");
        }

    }

}