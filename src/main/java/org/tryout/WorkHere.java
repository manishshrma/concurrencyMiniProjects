package org.tryout;

public class WorkHere {

    int age;
    String name;

    public WorkHere(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public synchronized void test(String name) {
        for (int i = 0; i < 3; i++) {
            System.out.println("run test function  "+name);
        }
    }
}
