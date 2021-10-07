package impProblems.problem1;

public class Thread1 extends Thread {

    @Override
    public void run() {
        synchronized (Thread.class) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 4; i++)
                System.out.println(i);
        }
        m1();
    }
    public void m1() {
        System.out.println("method m1");
    }

}