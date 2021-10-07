package rough2;

import java.util.stream.IntStream;

public class Display {
    public static synchronized void wish(String name) {

        IntStream.range(0, 7).forEach((x -> {
            System.out.println(Thread.currentThread().getName() + "->"+name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }
}
