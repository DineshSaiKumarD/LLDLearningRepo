package EasyLevel;

import java.util.concurrent.Semaphore;

public class ABCPrinter {

    public static void main(String[] args) {
        Semaphore sema = new Semaphore(1);
        Semaphore semb = new Semaphore(0);
        Semaphore semc = new Semaphore(0);

        int n = 2;


        Thread t1 = new Thread(() -> {
           for( int i =0 ; i < n; i++) {

                try {
                    sema.acquire();
                    System.out.println("T1 "+"A");
                    semb.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for( int i =0 ; i < n; i++) {

                try {
                    semb.acquire();
                    System.out.println("T2 "+"B");
                    semc.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for( int i =0 ; i < n; i++) {

                try {
                    semc.acquire();
                    System.out.println( "T3 " +"C");
                    sema.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
