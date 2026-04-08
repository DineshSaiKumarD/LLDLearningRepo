package EasyLevel;

import java.util.concurrent.Semaphore;

public class PingPongSemaphore {

    public static void main(String[] args) {
        Semaphore ping = new Semaphore(1);
        Semaphore pong = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    ping.acquire();
                    System.out.print("Ping ");
                    pong.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    pong.acquire();
                    System.out.print("Pong ");
                    ping.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
    }}});

        t1.start();
        t2.start();



}


}

