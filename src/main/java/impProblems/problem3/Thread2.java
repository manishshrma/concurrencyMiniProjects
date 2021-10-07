package impProblems.problem3;

import java.util.stream.IntStream;

public class Thread2 extends Thread{

    @Override
    public void run() {
        IntStream.range(0,4).forEach((idx)->{
            System.out.println("child thread 2");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        synchronized (this) {
            System.out.println("about to give notification");
            try {
                Thread.sleep(10);
                this.notify();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        IntStream.range(0,4).forEach((idx)->{
            System.out.println("child thread 2 extras");
        });

    }
}
