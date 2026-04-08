package EasyLevel.MyCustomThreadPool;

public class CustomThreadPoolMain {

    public static void main(String[] args) throws InterruptedException {
        MyCustomThreadPool myCustomThreadPool = new MyCustomThreadPool(3);

        for(int i = 0; i < 10; i++) {
            myCustomThreadPool.execute(new MyTask(i));
        }

    }
}
