package AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Basicpart3 {
    // learn- combine two async result
    public static CompletableFuture<Integer> create(int val) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> val);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = create(2);
        cf.thenCombine(create(3), (a, b) -> a + b)   // first cf combine with another cf and then return another combined cf.
                .thenAccept(System.out::println);


//        future.completeOnTimeout(100,3, TimeUnit.SECONDS); // complete with in 3 second, otherwise return 100
//        or if it fails within or blow up , it will throw exception

    }

}
