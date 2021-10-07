package org.interThread;

import impProblems.problem3.Thread1;

public class ThreadB extends Thread {

    int total = 0;

    @Override
    public synchronized void run() {

        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total = total + i;
            }
            System.out.println("about to give notification to the waiting thread OBJECT");
            this.notify();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println("notification has been given to the calling thread ");
        }
        //some 1 million followed
    }
}
