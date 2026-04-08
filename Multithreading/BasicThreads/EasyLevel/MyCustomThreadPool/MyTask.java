package EasyLevel.MyCustomThreadPool;

public class MyTask  implements Runnable{

    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " is running by " + Thread.currentThread().getName());
    }


}
