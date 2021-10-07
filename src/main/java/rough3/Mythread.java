package rough3;

import org.PDclassicProblem.Consumer;

import java.util.stream.IntStream;

public class Mythread implements Runnable{
    @Override
    public void run() {
        IntStream.range(0,6).forEach((x)-> System.out.println(" Mythread "+x));
    }
}
