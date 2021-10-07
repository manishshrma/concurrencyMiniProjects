package org.tryout;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock=new ReentrantLock();
        Thread1 t1=new Thread1(lock);
        t1.start();
        Thread2 t2=new Thread2(lock);
        t2.start();
        System.out.println("END.....Start whatever");

    }
}
