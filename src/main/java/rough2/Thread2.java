package rough2;

import java.util.stream.IntStream;

public class Thread2 implements Runnable {
    Display d;
    String name;

    Thread2(Display d, String name) {
        this.d = d;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream.range(0,6).forEach(idx-> System.out.println(Thread.currentThread().getName()));
        d.wish(name);

    }
}
