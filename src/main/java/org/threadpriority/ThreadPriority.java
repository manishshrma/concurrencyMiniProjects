package org.threadpriority;

import javax.swing.plaf.TableHeaderUI;

public class ThreadPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority()+" child thred priority");
    }
}
