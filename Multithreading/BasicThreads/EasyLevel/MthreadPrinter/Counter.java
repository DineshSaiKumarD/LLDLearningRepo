package EasyLevel.MthreadPrinter;

public class Counter {

    int cnt;

    public Counter() {
        cnt = 1;
    }

    public void increment() {
        cnt++;
    }

    public int getCnt() {
        return cnt;
    }

    public void reset() {
        cnt = 1;
    }

    public void print() {
        System.out.println("Count: " + cnt);
    }
}
