package AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class BasicPart1 {

    public static ForkJoinPool forkJoinPool=new ForkJoinPool(10); // You can use your own thread pool to execute
    // async calls,

    public static CompletableFuture<Integer> create() {
        System.out.println("create method " + Thread.currentThread());
        // this supplyAsync method call the compute() in asynch manner or in seperate thread (from common thread pool)
        return CompletableFuture.supplyAsync(() -> {
            try {
                return compute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    public static int compute() throws InterruptedException {
//        Thread.sleep(3000);
        System.out.println("compute Method:: " + Thread.currentThread());
        return 2;
    }


    public static void main(String[] args) {
        System.out.println("main method ::  " + Thread.currentThread());

        // interesting thing::::
        // if create() method completed, then thenAccept() will perform the printIt() on the same main thread.
        // think, if create() method that get executed on another thread but that thread performed it's task.
        // so why that thread need to wait.
        create().thenAccept(data -> printIt(data));
    }

    private static void printIt(int data) {
        System.out.println("PrintIt method :: " + Thread.currentThread());
        System.out.println(data);
    }
}
