import java.util.HashMap;
import java.util.concurrent.*;
public class FutureExample {
    public static void main(String[] args) {
        // Create an executor service with a single thread.
        ExecutorService executor = Executors.newSingleThreadExecutor();



        // Submit a task that simulates work (sleep for 1 second) and returns a string.
        Future<String> future = executor.submit(() -> {
            Thread.sleep(1000); // Simulate a delay
            return "Result from Future";
        });

        try {
            // Blocking call: waits for the result.
            String result = future.get();
            System.out.println("Future result: " + result);

            // Additional operation after the result is retrieved.
            System.out.println("Processing after Future result");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shut down the executor.
            executor.shutdown();
        }


    }
}