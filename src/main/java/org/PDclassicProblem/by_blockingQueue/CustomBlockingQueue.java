package org.PDclassicProblem.by_blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<T extends Number> {
    private Queue<T> queue=new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock(true);
    private  final int cap;

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public CustomBlockingQueue(int cap) {
        this.cap=cap;
    }


    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == cap) {
                // block the thread and release the lock,and only get woke
                // up when signalAll get called
                // once woke up it acquire the same lock that was released
                notFull.await();
            }
            queue.add(t);
            System.out.println(Thread.currentThread().getName() + " produced and added to queue: " + t);
            notEmpty.signalAll(); // signal all other thread waiting on that condition
            // don't release the lock,have to call lock.unlock explicitly
        } finally {
            lock.unlock();
        }

    }

    public T take() throws InterruptedException {
        lock.lock();
        try {

            while (queue.size() == 0) {
                // block thread
                notEmpty.await();
            }

            T t = queue.poll();
            System.out.println(Thread.currentThread().getName() + " consumed and removed from queue: " + t);
            notFull.signalAll();
            return t;
        } finally {
            lock.unlock();
        }
    }
}
