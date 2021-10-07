package org.sync;

//Race condition in Java occurs in a multi-threaded environment when more than one thread try to access a
// shared resource (modify, write) at the same time. Since multiple threads try to race each other to finish
// executing a method thus the name race condition.
public class Display {
    public  void wish(String name) {

        for (int i = 0; i < 5; i++) {
            System.out.println("this shdn't come under sync block "+name);
        }
        synchronized (this) { // object level lock
            for (int i = 0; i < 6; i++) {
                System.out.println("Good morning " + name);
                try {
                    Thread.sleep(10);


                } catch (InterruptedException ie) {
                    System.out.println(name);
                }
            }
        }
    }
}
