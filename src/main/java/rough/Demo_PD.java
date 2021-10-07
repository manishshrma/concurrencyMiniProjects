package rough;

import java.util.ArrayList;

public class Demo_PD {


    public static void main(String[] args) {
        ArrayList<Integer> taskqueue=new ArrayList<>();
        int MAX_LIMIT=5;

        Producer_guy pd=new Producer_guy(taskqueue,MAX_LIMIT);
        pd.start();
        Consumer_guy cs=new Consumer_guy(taskqueue);
        cs.start();

    }
}
