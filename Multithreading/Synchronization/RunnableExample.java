class MyRunnable implements Runnable {

    // Implement the run method from Runnable interface
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable " + Thread.currentThread().getId() + " is running: " + i);
            try {
                Thread.sleep(500); // Pause execution for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable(); // Create runnable instance

        Thread thread1 = new Thread(runnable); // Create thread with runnable
        Thread thread2 = new Thread(runnable); // Create another thread with same runnable

        thread1.start(); // Start the first thread
        thread2.start(); // Start the second thread
    }
}
