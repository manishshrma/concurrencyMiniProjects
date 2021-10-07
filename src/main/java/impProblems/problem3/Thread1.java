package impProblems.problem3;

import java.util.stream.IntStream;

public class Thread1 extends Thread {

    @Override
    public void run() {
           Thread2 blocker=new Thread2();

           synchronized (blocker) {
               try {
                   System.out.println("About to put on wait");

                   blocker.wait();
                   System.out.println("just got notification");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        IntStream.range(0,4).forEach((idx)->{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child thread 1");
        });
    }
}
