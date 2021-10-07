package rough2;

import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        Display d1=new Display();
        Display d2=new Display();

        //thread 1
        Thread1 r1=new Thread1(d1,"groote");
        Thread t1=new Thread(r1,"my child 1"); // my child 1 is the name assigned to the thread1
        // thread 2
        Thread2 r2=new Thread2(d2,"manish");
        Thread t2=new Thread(r2,"my child 2");

        t1.start();
        t2.start();
        IntStream.range(0,6).forEach((x)-> System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId()));
    }
}
