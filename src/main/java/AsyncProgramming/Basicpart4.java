package AsyncProgramming;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Basicpart4 {
    // learn- compose is like flatMap
    // instead of getting Completablefuture of CompletableFuture, it return the Completable of data itself.
    public static CompletableFuture<Integer> create(int val) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> val);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        create(3).thenCompose(data-> {
                    try {
                        return create(4);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .thenAccept(System.out::println);
    }

}
