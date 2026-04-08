import java.util.concurrent.*;
public class FutureResultExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> 10 + 20);
        if (future.isDone()) {
            System.out.println("Task completed!"); // Prints -> Task completed!
        } else {
            System.out.println("Still working..."); // Prints -> Still working...
        }
        Integer result = future.get();  // blocks until result is ready
        System.out.println("Result: " + result);  // Result: 30
        if (future.isDone()) {
            System.out.println("Task completed!"); // Prints -> Task completed!
        } else {
            System.out.println("Still working..."); // Prints -> Still working...
        }
        executor.shutdown();
    }
}