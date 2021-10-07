package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        PrintJob[] jobs = {
                new PrintJob("groote"),
                new PrintJob("manish"),
                new PrintJob("awsm"),
                new PrintJob("ask")
        };

        ExecutorService service= Executors.newFixedThreadPool(3);

        for(PrintJob job:jobs){
            service.submit(job);
        }
        service.shutdown();
    }
}
