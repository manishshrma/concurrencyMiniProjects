package AsyncProgramming;

import java.time.format.ResolverStyle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class UnderstandingAsync3 {

    public static String phoneAllowedForWhom(String whoIs) {
        String res = "";
        try {
            System.out.println("thread 1 " + Thread.currentThread().getName());
            Thread.sleep(6000);
            System.out.println("Is Phone Allowed in School");
            if (whoIs.equalsIgnoreCase("Staff") || whoIs.equalsIgnoreCase("Parents")) {
                res = "Phone allowed for " + whoIs;
            } else {
                System.out.println("No phone now");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return res;
    }

    public static String staffComplianceCheck(String timespend) {
        String res = "";
        System.out.println("thread 2 " + Thread.currentThread().getName());
        throw new RuntimeException("Error!!");
//        try {
//            Thread.sleep(2000);
//            System.out.println("Is time spend too much on phone during lecutures");
//            if (timespend.equalsIgnoreCase("too much") || timespend.equalsIgnoreCase("much")) {
//                res = "Think once again as time spend " + timespend;
//            } else {
//                System.out.println("No phone allowed!");
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return res;
    }

    public static String takeActions(String takeAction) {
        String res = "";
        System.out.println("thread 3 " + Thread.currentThread().getName());

        try {
            Thread.sleep(4000);
            System.out.println("Going take action as per the reports");
            if (takeAction.equalsIgnoreCase("allowed")) {
                res = "Phone is " + takeAction;
            } else {
                System.out.println("Phone is restricted for break only!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return res;
    }
    public static ResponseHandler partialResponseHandler(CompletableFuture<String> res1, CompletableFuture<String> res2, CompletableFuture<String> res3, CompletableFuture<Void> res) {
        AtomicBoolean flag1 = new AtomicBoolean(false);
        AtomicBoolean flag2 = new AtomicBoolean(false);
        try {
            res1.get();
            res2.get();
        } catch (Exception e) {
            res1.whenCompleteAsync((response, err) -> {
                if (err != null) {
                    throw new RuntimeException(err.getCause());
                }
                flag1.set(true);
            });
            res2.whenCompleteAsync((response, err) -> {
                if (err != null) {
                    throw new RuntimeException(err.getCause());
                }
                flag2.set(true);
            });


            if (flag1.get() == true && flag2.get() == true) {
                return new ResponseHandler("Success", "201");
            } else if (flag1.get() == false && flag2.get() == false) {
                return new ResponseHandler("Failed", "500");
            } else {
                return new ResponseHandler("Partial Success", "207");
            }
        }

        return null;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.nanoTime();
        CompletableFuture<String> res1 = CompletableFuture.supplyAsync(() -> phoneAllowedForWhom("Staff"));
        CompletableFuture<String> res2 = CompletableFuture.supplyAsync(() -> staffComplianceCheck("much"));
        CompletableFuture<String> res3 = CompletableFuture.supplyAsync(() -> takeActions("allowed"));
        CompletableFuture<Void> res = CompletableFuture.allOf(res1, res2, res3);
        ResponseHandler result = partialResponseHandler(res1, res2, res3, res);
        System.out.println(result);
        long end = System.nanoTime();
        long executionTime = (end - start) / 1000000;
        System.out.println("Execution time is " + executionTime + " millisecond");

        System.out.println("test");

    }
}
