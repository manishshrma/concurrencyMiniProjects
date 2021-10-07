package rough3;

import java.util.stream.IntStream;

public class Otherthread implements Runnable{
    @Override
    public void run() {
        IntStream.range(0,6).forEach((x)-> System.out.println(" other thread "+x));

    }
}
