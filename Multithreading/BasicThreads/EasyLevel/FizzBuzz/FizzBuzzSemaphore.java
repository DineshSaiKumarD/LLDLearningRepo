package EasyLevel.FizzBuzz;

import java.util.concurrent.Semaphore;

public class FizzBuzzSemaphore{

    int counter = 1;
    int n = 15;

    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore fizzBuzz = new Semaphore(0);
    Semaphore number = new Semaphore(1);


    public void fizz(){
        while(true){

                try {
                    fizz.acquire();
                    if(counter > n) break;
                    System.out.println("Fizz " + counter + " " + Thread.currentThread().getName());

                    counter++;
                    number.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }

    public void buzz(){
        while(true){

                try {
                    buzz.acquire();
                    if(counter > n) break;

                    System.out.println("Buzz " + counter + " " + Thread.currentThread().getName());
                    counter++;

                    number.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }

    public void fizzBuzz(){
        while(true){
                try {
                    fizzBuzz.acquire();
                    if(counter > n) break;

                    System.out.println("FizzBuzz " + counter + " " + Thread.currentThread().getName());
                    counter++;

                    number.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }


    public void number() throws InterruptedException {
        while(true){

               number.acquire();

               if(counter > n){
                   number.release();
                   fizz.release();
                   buzz.release();
                   fizzBuzz.release();

                   break;
               }

               if(counter % 3 == 0 && counter % 5 == 0){
                   fizzBuzz.release();
               }else if(counter % 3 == 0 && counter % 5 != 0){
                   fizz.release();
               }else if(counter % 5 == 0 && counter % 3 != 0){
                   buzz.release();
               }else{
                   System.out.println(counter + " " + Thread.currentThread().getName());
                   counter++;
                   number.release();
               }

        }
    }



}
