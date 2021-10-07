package impProblems.problem1;

public class Thread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Thread.class) {
            for (int i = 10; i < 14; i++)
                System.out.println(i);
        }
        m2();
    }
    public void m2() {
        System.out.println("method m2");
    }
}
