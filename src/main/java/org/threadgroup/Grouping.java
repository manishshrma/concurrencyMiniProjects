package org.threadgroup;

public class Grouping {
    public static void main(String[] args) {
        //this thread belong to main thread group as it is created by main thread which present in
        //main thread group
        ThreadGroup g1=new ThreadGroup("firstGroup");
        System.out.println(g1.getName());

        //this threadgroup will be add as child of g1(parent threadgroup) present in firstgroup
        ThreadGroup g2=new ThreadGroup(g1,"secondGroup");
        System.out.println(g2.getParent().getName());

        /////////////thread prioriy in thread group//////////////////////////////

        ThreadGroup gp=new ThreadGroup("mygroup");//-- have MAX_priority is 10
        Thread t1=new Thread(gp,"thread-0"); // now priority--5
        Thread t2=new Thread(gp,"thread-1");// now priority --5
        //set the thredgroup priority
        gp.setMaxPriority(3); // setted new priority
        Thread t3=new Thread(g1,"thread-3");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());


    }
}
