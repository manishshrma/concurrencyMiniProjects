package impProblems.problem3;

import java.util.stream.IntStream;

public class MainThread {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread2 t2 = new Thread2();
        t2.start();

        IntStream.range(0, 4).forEach((idx) -> {
            System.out.println("main thread");
        });
    }
}
