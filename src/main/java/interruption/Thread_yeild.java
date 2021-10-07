package interruption;

import java.util.stream.IntStream;

public class Thread_yeild {
//    Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds,
//    subject to the precision and accuracy of system timers and schedulers. The thread does not lose ownership of any monitors.
//    Params:
//    millis – the length of time to sleep in milliseconds
//    Throws:
//    IllegalArgumentException – if the value of millis is negative
//    InterruptedException – if any thread has interrupted the current thread. The interrupted status of the current thread is
//    cleared when this exception is thrown.
    public static void main(String[] args) throws InterruptedException {
        Thread.yield();  // it pause the current thread execution and so current thread goes into the ready/runnable state
//        Thread.sleep(1000);

        IntStream.range(0,10).forEach((x)-> System.out.println(Thread.currentThread().getName()));

    }
}
