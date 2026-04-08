package EasyLevel.ProducerCnsumerProblem.UsingRentrantLock;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private int capacity;

    private Queue<String> queue ;

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();



    public Buffer(int capacity) {
        this.capacity = capacity;
        this.queue = new java.util.LinkedList<>();
    }

    public void addToBuffer(String item) throws InterruptedException {

            lock.lock();
            while (queue.size() == capacity) {
                notFull.await();
            }
            this.queue.add(item);
            notEmpty.signalAll();
            lock.unlock();
    }

    public void consumeFromBuffer() throws InterruptedException {
            lock.lock();
            while (queue.size() == 0) {
                this.wait();
                notEmpty.await();
            }
            System.out.println("Consumed: " + this.queue.poll());
            notFull.signalAll();
            lock.unlock();

    }



}
