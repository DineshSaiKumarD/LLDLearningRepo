package EasyLevel.ProducerCnsumerProblem.UsingWaitNotify;

import java.util.Queue;

public class Buffer {

    private int capacity;

    private Queue<String> queue ;


    public Buffer(int capacity) {
        this.capacity = capacity;
        this.queue = new java.util.LinkedList<>();
    }

    public void addToBuffer(String item) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == capacity) {
                this.wait();
            }
            this.queue.add(item);
            this.notifyAll();
        }
    }

    public void consumeFromBuffer() throws InterruptedException {
        synchronized (this) {
            while (queue.size() == 0) {
                this.wait();
            }
            System.out.println("Consumed: " + this.queue.poll());
            this.notifyAll();
        }
    }



}
