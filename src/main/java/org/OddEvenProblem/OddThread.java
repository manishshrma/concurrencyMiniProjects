package org.OddEvenProblem;

public class OddThread implements Runnable{

    Numobj n2;
    OddThread(Numobj n2){
        this.n2=n2;
    }
    @Override
    public void run() {

        while(true) {

            synchronized (n2) {
                if (n2.num % 2 != 0) {

                    System.out.println("odd" + n2.num);
                    n2.num++;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        n2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}
