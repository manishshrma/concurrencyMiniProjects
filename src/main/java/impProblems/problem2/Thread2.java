package impProblems.problem2;

public class Thread2 extends Thread {
    Display d;

    Thread2() {

    }

    Thread2(Display d) {
        this.d = d;
    }

    @Override
    public void run() {
        try {
            d.getname("Thread 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
