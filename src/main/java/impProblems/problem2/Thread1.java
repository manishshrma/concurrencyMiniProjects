package impProblems.problem2;
public class Thread1 extends Thread {
    Display d;
    Thread1(){

    }
    Thread1(Display d) {
        this.d = d;
    }
    @Override
    public void run() {
        try {
            d.getname("Thread 1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
