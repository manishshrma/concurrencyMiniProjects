package org.OddEvenProblem;

public class EvenThread implements Runnable{

    Numobj n1;
    EvenThread(Numobj n1){
        this.n1=n1;
    }

    @Override
    public void run() {

        while(true){

            synchronized (n1) {
                if (n1.num % 2 == 0) {
                    System.out.println("even" + n1.num);
                    n1.num++;

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    n1.notifyAll();
                }
            }

        }

    }
}
