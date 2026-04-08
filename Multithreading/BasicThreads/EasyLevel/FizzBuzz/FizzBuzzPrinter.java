package EasyLevel.FizzBuzz;

public class FizzBuzzPrinter {


    public static void main(String[] args) {
        FizzBuzzSemaphore f = new FizzBuzzSemaphore();

        Thread t1 = new Thread(() -> f.fizz() );
        Thread t2 = new Thread(() -> f.buzz() );
        Thread t3 = new Thread(() -> f.fizzBuzz() );
        Thread t4 = new Thread(() -> {
            try {
                f.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
