package AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Basicpart2 {
    // talk about pipeline
    public static void process(CompletableFuture<Integer> future) throws ExecutionException, InterruptedException {
        future.thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);

        System.out.println(future.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        process(future); // this method create a pipeline
        // think as you call webservice of google asking for stock price by giving some input which you have not yet,
        // but you at least created a pipeline what to do when data is available with you.

        future.complete(2);  // you pass the data to the pipeline you created.
    }

}
