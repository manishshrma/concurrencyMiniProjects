package concurrent1;

import java.util.concurrent.locks.ReentrantLock;

public class Overcome_sync {
    //overcome the synchronization problems
    //1. if lock is not present with object, take another mechanism to execute.
    //2. now, can decide which thread will get the chance.
    //3. can know how many waiting thread are .
    // so  using java.util.concurrent package give all these features and overcome the problems
    //with synchronization
    ReentrantLock l=new ReentrantLock();// creating a lock
    ReentrantLock l1=new ReentrantLock(true);// now longest  wating thread will get the chance


}
