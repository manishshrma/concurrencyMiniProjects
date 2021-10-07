package org.sync;

public class Sync {
    public static void main(String[] args) {
        Display d1=new Display();
//        Display d2=new Display();

        Mythread mt=new Mythread(d1,"manish");
        mt.start();
        Mythread mt2=new Mythread(d1,"groote");
        mt2.start();



    }
}
