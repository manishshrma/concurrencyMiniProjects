package AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Basicpart2 {


//    ---X---F---X-----F-------X-----F   (PATH 1) resolve, pending
//             \
//              \
//    -----E----F----E------F--E------   (PATH 2) error


    public static int handleException(Throwable throwable) {
        System.out.println("ERROR: " + throwable);
        return 100;  // recover from exception so back to path 1
    }

    // talk about pipeline
    public static void process(CompletableFuture<Integer> future) throws ExecutionException, InterruptedException {
        future.thenApply(data -> data * 2)
                .exceptionally(throwable -> handleException(throwable))
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);

        System.out.println(future.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        process(future); // this method create a pipeline
        // think as you call webservice of google asking for stock price by giving some input which you have not yet,
        // but you at least created a pipeline what to do when data is available with you.

//        future.complete(2);  // you pass the data to the pipeline you created.
        future.completeExceptionally(new RuntimeException("Something went Wrong"));
    }

}
