package AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UndestandingAsync1 {

    public static CompletableFuture<Integer> create(int val) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> val * 2);
    }

    public static CompletableFuture<Integer> develop(int inputofVal) {
        try {
            return CompletableFuture.supplyAsync(() -> inputofVal + 100);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long st = System.nanoTime();
// Just Using asyn
        create(2)
                .thenCompose((data) -> develop(data))
                .thenAccept((data) -> System.out.println(data));
        long en = System.nanoTime();

        long executionTime = (en - st) / 1000000;

        System.out.println("Execution time " + executionTime + " millisecond");

    }
}
