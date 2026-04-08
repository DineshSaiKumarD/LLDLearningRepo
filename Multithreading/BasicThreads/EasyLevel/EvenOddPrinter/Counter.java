package EasyLevel.EvenOddPrinter;

public class Counter {

    int cnt;

    public Counter() {
        cnt = 0;
    }

    public void increment() {
        cnt++;
    }

    public int getCnt() {
        return cnt;
    }

    public void reset() {
        cnt = 0;
    }

    public void print() {
        System.out.println("Count: " + cnt);
    }
}
