package EasyLevel.EvenOddPrinter;



public class OddPrinterThread extends Thread {

    private Counter counter;

    private int maxCount;

    public OddPrinterThread(Counter counter,int maxCount) {
        this.counter = counter;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {

        while(true && counter.cnt <= maxCount){
        if(counter.cnt % 2 != 0 ) {
            System.out.println("Odd Thread counter : " + counter.cnt);
            counter.increment();
        }}
    }



}
