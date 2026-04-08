package EasyLevel.ProducerCnsumerProblem.UsingRentrantLock;

import EasyLevel.ProducerCnsumerProblem.UsingWaitNotify.Buffer;

public class RentrantMain {

    public static void main(String[] args) {

        EasyLevel.ProducerCnsumerProblem.UsingWaitNotify.Buffer buffer = new Buffer(10);

       Thread producerThread = new Thread(() -> {
           for (int i = 1; i <= 10; i++) {
               try {
                   buffer.addToBuffer("Item " + i);
                   System.out.println("Producer added: Item " + i);
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
       }}});


       Thread consumerThread = new Thread(() -> {
           for (int i = 1; i <= 10; i++) {
               try {
                   buffer.consumeFromBuffer();
                   Thread.sleep(2000);

               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       });


       producerThread.start();
       consumerThread.start();


    }
}
