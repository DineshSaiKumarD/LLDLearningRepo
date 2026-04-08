package EasyLevel.EvenOddPrinter;

public class EvenPrinterThread extends Thread {

    private Counter counter;

    private int maxCount;

    public EvenPrinterThread(Counter counter,int maxCount) {
        this.counter = counter;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {

        while(true && counter.cnt <= maxCount){
        if(counter.cnt % 2 == 0 ) {

            System.out.println("Even Thread counter : " + counter.cnt);

            counter.increment();
        }}
    }



}
