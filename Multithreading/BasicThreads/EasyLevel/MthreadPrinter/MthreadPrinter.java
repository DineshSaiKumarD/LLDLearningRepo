package EasyLevel.MthreadPrinter;

import java.util.Scanner;

public class MthreadPrinter {

    public static void main(String[] args) {
        Counter counter = new Counter(); //onject will be stored in heap

        //ask to enter thread value from user

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Thread count value : ");
        int threadValue = sc.nextInt();


        Thread t0 = new Printer(counter, 10 , threadValue,0) ;
        Thread t1 = new Printer(counter, 10 , threadValue,1) ;
        Thread t2 = new Printer(counter, 10 , threadValue,2) ;


        t0.start();
        t1.start();
        t2.start();


    }
}
