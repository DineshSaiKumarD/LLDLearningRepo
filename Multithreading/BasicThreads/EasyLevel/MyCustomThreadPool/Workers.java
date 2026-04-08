package EasyLevel.MyCustomThreadPool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Workers extends Thread {

    private BlockingQueue<MyTask> queue;

    public Workers(BlockingQueue<MyTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                 queue.take().run();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
