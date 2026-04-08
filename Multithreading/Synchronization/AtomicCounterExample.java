import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {
   // private static AtomicInteger counter = new AtomicInteger(0);
    private static volatile int counter = 0;
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                //counter.incrementAndGet(); // Thread-safe
                counter++;
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter);
        // ✅ Should be 2000 always if u use AtomicInteger --> volatile and atomic
        //Final counter value: 17103 varies everytime because it is just volatile not atomic
    }
}

