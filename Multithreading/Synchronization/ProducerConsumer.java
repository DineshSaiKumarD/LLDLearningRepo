import java.util.LinkedList;
import java.util.Queue;
public class ProducerConsumer {
    // Shared buffer and its capacity
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 5;

    // Method for the producer thread that adds items to the buffer.
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // Wait while the buffer is full.
                while (buffer.size() == CAPACITY) {
                    System.out.println("Buffer is full. Producer is waiting...");
                    wait();
                }
                // Once there is space, produce an item.
                System.out.println("Producer produced: " + value);
                buffer.offer(value++);
                // Notify all waiting threads (consumers) that a new item is available.
                notifyAll();
            }
            // Sleep for a short time to simulate production time.
            Thread.sleep(1000);
        }
    }

    // Method for the consumer thread that takes items from the buffer.
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Wait while the buffer is empty.
                while (buffer.isEmpty()) {
                    System.out.println("Buffer is empty. Consumer is waiting...");
                    wait();
                }
                // Once there is an item, consume it.
                int value = buffer.poll();
                System.out.println("Consumer consumed: " + value);
                // Notify all waiting threads (producers) that space is available.
                notifyAll();
            }
            // Sleep for a short time to simulate consumption time.
            Thread.sleep(1500);
        }
    }

    // Main method to run the producer-consumer example.
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        // Creating the producer thread.
        Thread producerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Producer thread interrupted.");
                }
            }
        }, "ProducerThread");

        // Creating the consumer thread.
        Thread consumerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Consumer thread interrupted.");
                }
            }
        }, "ConsumerThread");

        // Start both threads.
        producerThread.start();
        consumerThread.start();
    }
}

/*
Sample Output:
Consumer consumed: 7
Producer produced: 11
Consumer consumed: 8
Producer produced: 12
Producer produced: 13
Consumer consumed: 9
Producer produced: 14
Consumer consumed: 10
Producer produced: 15
Buffer is full. Producer is waiting...
Consumer consumed: 11
Producer produced: 16
Buffer is full. Producer is waiting...
Consumer consumed: 12
Producer produced: 17*/
