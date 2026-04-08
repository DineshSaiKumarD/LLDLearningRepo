package EasyLevel.MthreadPrinter;



public class Printer extends Thread {

    private Counter counter;

    private int maxCount;

    private int threadCount;

    private int threadId;

    public Printer(Counter counter, int maxCount, int threadCount,int threadId) {
        this.counter = counter;
        this.maxCount = maxCount;
        this.threadCount = threadCount;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter) {

                if (counter.cnt >= maxCount) {
                    counter.notifyAll();
                    break;
                }

                while ((counter.cnt - 1) % threadCount != threadId) {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("Thread " + threadId + " counter : " + (counter.cnt - 1));
                counter.increment();

                counter.notifyAll();
            }
        }
    }


}
