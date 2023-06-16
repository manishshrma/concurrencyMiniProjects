package ExecutorService_2;

import ExecutorService.PrintJob;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumJob[] jobs = {
                new SumJob(3),
                new SumJob(4),
                new SumJob(5),
                new SumJob(2),
                new SumJob(3),

        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (SumJob job : jobs) {
            //Future hold the return type from service submit method
            Future r= service.submit(job);
            // all the jobs, getting executed in seperate thread.
            // but as soon as main thread encounter the .get(). then immediately it get blocked,
            // and wait for the response to come before moving furthre.
            System.out.println("--------------------------");
            System.out.println(r.get());
        }
        service.shutdown();
    }
}
