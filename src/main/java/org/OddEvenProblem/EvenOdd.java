package org.OddEvenProblem;

public class EvenOdd {

    public static void main(String[] args) {

        Numobj no=new Numobj();

        Thread t1=new Thread(new EvenThread(no));
        Thread t2=new Thread(new OddThread(no));
        t1.start();
        t2.start();
    }
}
