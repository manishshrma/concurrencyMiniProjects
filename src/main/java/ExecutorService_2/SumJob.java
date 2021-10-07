package ExecutorService_2;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumJob implements Callable {
    int num;

   public SumJob(int num) {
        this.num = num;
    }

    public Object call() throws Exception {
        int sum=0;
        System.out.println(num + " job started by thread" + Thread.currentThread().getName());
        try {

            Thread.sleep(100);
             sum= IntStream.range(0, num).sum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sum ;
    }
}
