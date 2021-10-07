package concurrent1;

import java.util.concurrent.locks.ReentrantLock;

public class Display {
    ReentrantLock l=new ReentrantLock();
    public void wish(String name) {
        l.lock(); // assume thread1 executing this one, so now thread1 got the lock
        for (int i = 0; i < 6; i++) {
            System.out.println("hello "+name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
            }
        }
        l.unlock();// release the lock

    }
}
