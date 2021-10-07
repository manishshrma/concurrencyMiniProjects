package impProblems.problem2;

import java.util.stream.IntStream;

public class Display {
    String name;

    public Display(String name) {
        this.name = name;
    }

    public void getname(String name) throws InterruptedException {

//In execution order the non-synchronized block follows the synchronized block. Therefore you will never see any
// thread executing the non-synchronized block before the synchronized block.

//        Thread1 lock1=new Thread1();
//        Thread2 lock2=new Thread2();
        synchronized (this) {
            Thread.sleep(100);
            IntStream.range(0, 5).forEach((idx) -> {
                System.out.println(name);
            });
            this.name=name;
        }

        IntStream.range(0, 5).forEach(x -> System.out.println("thread Unsafe Zone,"+name));

    }
}
