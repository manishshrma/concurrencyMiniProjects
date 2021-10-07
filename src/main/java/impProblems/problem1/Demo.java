package impProblems.problem1;

// problem: if anythread get chance to execute, it must complete its execution,and then another one get chance it's should
//also complete its execution and so on.
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Thread1 t1=new Thread1();
        t1.start();
        Thread2 t2=new Thread2();
        t2.start();

    }
}
