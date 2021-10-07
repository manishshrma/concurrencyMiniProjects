package org.thread.basic;

import java.util.stream.IntStream;
// creation of thread by extending thread class
public class ThreadingByThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("child thread");
        }
    }

}
