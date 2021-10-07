package org.sync;

public class Mythread extends Thread {
    Display d;
    String name;

    Mythread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
          d.wish(name);
    }
}
