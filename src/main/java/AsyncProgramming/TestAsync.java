package AsyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class TestAsync {

    public static String mostRecentQuestionAskedAbout(String type) {
        System.out.println("in 1st" + Thread.currentThread().getName());
        return "What is CompletableFuture";
    }

    public static String questionFromUpperCase(String firstinput) {
        AtomicReference<String> manipultion = new AtomicReference<>("");
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("in 2nd" + Thread.currentThread().getName());
//                Thread.sleep(6000);
//                System.out.println("AAAAAAAAAAAA");
                manipultion.set("AAAAAAAAAA");
                return firstinput.toUpperCase();
            } catch (Exception e) {
                System.out.println("In error!!");
            }
            return null;
        });
        return firstinput.toUpperCase() + "   BBBB    "+manipultion.get();
    }

    public static String tryToAnswer(String quesInput) {

        CompletableFuture.supplyAsync(() -> {

            System.out.println("in 3rd" + Thread.currentThread().getName());

            return "What is CompletableFuture? " + quesInput + "correct the ques first";
        });
        return "What is CompletableFuture? " + quesInput + "correct the ques first";
    }

    public static String answer(String correctQues) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("in last" + Thread.currentThread().getName());
            return correctQues + " ANS: <<NO OUTPUT>>";
        });
        return correctQues + " ANS: <<NO OUTPUT>>";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        long startTime = System.nanoTime();

        CompletableFuture<String> java = CompletableFuture.supplyAsync(() -> mostRecentQuestionAskedAbout("java"));


        CompletableFuture<String> res = java.thenApply((resFromjava) -> questionFromUpperCase(resFromjava))
                .thenApply((resFromQues) -> tryToAnswer(resFromQues))
                .thenApply((correctQues) -> answer(String.valueOf(correctQues)));


        System.out.println(
                "Test.................."
        );
        CompletableFuture<Void> ifAllcompleted = CompletableFuture.allOf(res);
        boolean isdone = ifAllcompleted.isDone();
        System.out.println(isdone);
//        ifAllcompleted.get(3, TimeUnit.MILLISECONDS);

        System.out.println(res.get());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("Execution time: " + duration + " millisecond");


    }
}
