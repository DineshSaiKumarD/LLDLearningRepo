

class MyThreadEx extends Thread {
    public void run() {
      //  try {
            throw new RuntimeException("Exception in thread");
      /*  } catch (Exception e) {
            System.out.println("Caught exception in thread: " + e.getMessage());
        }*/
    }
}

public class ExceptionNotPropagatesToMain {
    public static void main(String[] args) throws InterruptedException {
        MyThreadEx t = new MyThreadEx();
        t.start(); // Starts a separate thread
        Thread.currentThread().sleep(5000);
        System.out.println("Main thread is running");
    }
}

//point here is that exception is not propagated to main --checked this by commenting the catch block
//output : Exception in thread "Thread-0" java.lang.RuntimeException: Exception in thread
//	at MyThreadEx.run(ExceptionNotPropagatesToMain.java:6)
//Main thread is running

//If you call t.run(); directly, it behaves like a normal method call and executes in the main thread, so the exception would be
//thrown in the main thread.
//
//By calling t.start();, the thread runs separately, and if an exception occurs in run(), it terminates that thread without
//affecting the main thread.
//
//The main thread continues execution and prints "Main thread is running" even if the child thread throws an exception.
