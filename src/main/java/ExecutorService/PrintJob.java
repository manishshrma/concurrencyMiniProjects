package ExecutorService;
// try to create same program using the callable and call method.
public class PrintJob implements Runnable {
    private String name;
    protected PrintJob(String name){
          this.name=name;
    }
    public void run()  {
        System.out.println(name+" ..job started by thread"+Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Job completed..");
    }
}
