package concurrent2;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    String name;
    static ReentrantLock l = new ReentrantLock();

    MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        if (l.tryLock()) {
            // try to get lock, assume first thread got the lock

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 6; i++) {
                System.out.println("child thread  " + name);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                System.out.println("alternate operation as this thread didn't get the lock");
            }
        }
    }
}
