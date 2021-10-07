package impProblems.problem2;
// problem- want to execute the particular part of the code (using synchronized block)
//https://stackoverflow.com/questions/66607441/multiple-thread-failed-to-execute-the-nonsynchronized-code-in-java/66607912#66607912
public class Demo {
    public static void main(String[] args) {

        Display d=new Display("AnyName");
        Thread1 t1=new Thread1(d);
        Thread2 t2=new Thread2(d);
        t1.start();
        t2.start();
    }
}
