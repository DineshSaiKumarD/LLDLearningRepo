package EasyLevel.EvenOddPrinter;

public class EvenOddPrinter {


    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread evenPrinterThread = new EvenPrinterThread(counter,10);
        Thread oddPrinterThread = new OddPrinterThread(counter,10);
        evenPrinterThread.start();
        oddPrinterThread.start();
    }

    
}
