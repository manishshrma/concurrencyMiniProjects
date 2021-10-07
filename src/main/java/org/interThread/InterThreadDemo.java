package org.interThread;

//Good stackoverflow link for wait and notify in this context.
//https://stackoverflow.com/questions/42995461/understanding-wait-and-notify-methods#:~:text=You%20could%20solve%20this%20by,(InterruptedException%20e)%20%7B%20System.
//Thread notify and wait on object
//https://stackoverflow.com/questions/16197135/how-can-the-wait-and-notify-methods-be-called-on-objects-that-are-not-thread
public class InterThreadDemo {
    //on calling wait method on thread, that thread IMMEDIATELY release lock of thay object on WHICH WAIT
    // get called
    // and then that thread goes into waiting state.
    public static void main(String[] args) throws InterruptedException {
        ThreadB tb=new ThreadB();
        tb.start();
        synchronized (tb){
            System.out.println("going in the waiting state");
            tb.wait();// current thread goes into waiting, will get notification once
            //other tb task or updation will complete and then this run.
        }
        System.out.println("got notified and total is "+tb.total);
    }
}
