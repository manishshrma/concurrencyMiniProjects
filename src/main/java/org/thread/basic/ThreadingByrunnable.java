package org.thread.basic;

public class ThreadingByrunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
        }
        System.out.println("Child Thread end here.....");
    }


}
