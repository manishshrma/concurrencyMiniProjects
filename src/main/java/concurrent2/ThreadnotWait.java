package concurrent2;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadnotWait {

    static ReentrantLock l = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new MyThread("groote");
        Thread t2 = new MyThread("manish");
        t1.start();
        t2.start();
    }
}
