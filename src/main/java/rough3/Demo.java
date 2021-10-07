package rough3;

import javax.print.attribute.standard.MediaSize;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) throws InterruptedException {


        int arr[]={1,4,3,54,54,6,4};


       OptionalInt res= IntStream.of(arr).min();

        System.out.println(res);


        System.out.println("------------------------------------");

        Mythread mythread = new Mythread();
        Otherthread otherthread = new Otherthread();

        Thread t1 = new Thread(mythread);
        t1.start();
        Thread t2 = new Thread(otherthread);
        t2.start();

    }
}
