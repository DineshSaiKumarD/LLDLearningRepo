public class ThreadExample {

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();

        myThread2.start();
        myThread1.start();
    }
}


//one way to create a thread
class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running: " + i);
            /*try {
                Thread.sleep(500); // Pause execution for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }*/
        }
    }
}

/*OUTPUT --- can't tell the order of execution
Thread 12 is running: 1
Thread 12 is running: 2
Thread 12 is running: 3
Thread 12 is running: 4
Thread 13 is running: 1
Thread 13 is running: 2
Thread 13 is running: 3
Thread 13 is running: 4*/
