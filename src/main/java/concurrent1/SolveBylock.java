package concurrent1;

// instead of synchronization keyword, which use the conecpt of lock,
//here i am using the Reentrancelock concept to get the lock
public class SolveBylock {
    public static void main(String[] args) {
        Display d=new Display();
        Mythread t1=new Mythread(d,"manish");
        Mythread t2=new Mythread(d,"groote");
        t1.start();
        t2.start();
    }

}
