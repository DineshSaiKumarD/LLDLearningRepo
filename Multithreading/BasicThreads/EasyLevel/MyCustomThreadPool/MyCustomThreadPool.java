package EasyLevel.MyCustomThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyCustomThreadPool {

    private int poolSize;
    private Workers[] workers;
    private BlockingQueue<MyTask> queue;

    public MyCustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.workers = new Workers[poolSize];
        this.queue = new LinkedBlockingDeque<>();

        for(int i = 0; i < poolSize; i++) {
            workers[i] = new Workers(queue);
            workers[i].start();

        }
    }

    public void execute(MyTask task) throws InterruptedException {
        queue.put(task);
    }






}
