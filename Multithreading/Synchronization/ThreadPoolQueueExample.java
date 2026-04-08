import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolQueueExample {
    public static void main(String[] args) {
        // ThreadPoolExecutor with 2 core threads, max 4 threads, and queue size of 2
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy() // Reject tasks if queue & max threads are full
        );

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is processing task " + taskId);
                try {
                    Thread.sleep(2000); // Simulating task execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
    }
}

/*

Behavior Based on Queue Size :
Small Queue (Size = 2) :

The first 2 tasks are assigned to core threads (Thread-1, Thread-2).
The next 2 tasks wait in the queue.
When the queue fills up, new threads (up to maxPoolSize = 4) are created.
If all 4 threads are busy and queue is full, new tasks are rejected (handled by AbortPolicy).
        ✅ Outcome: Faster execution due to additional threads, but at the cost of higher CPU load.


Large Queue (Size = 6) :

The first 2 tasks are executed by core threads.
The next 6 tasks are queued instead of creating new threads.
Additional threads are not created until the queue is full.
        ✅ Outcome: Less CPU usage, but tasks may take longer to start. */
