package labTasks.lab3;

import java.util.Random;


class Generate {
    private static int stock = -1;

    synchronized void put(){
        Random rand = new Random();
        stock = rand.nextInt(100);
        System.out.println(Thread.currentThread().getName() + " " + stock);
        notify();
        try{
            wait();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized void get()  {
        if (stock == -1){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + stock);
        stock = -1;
        notify();
    }
}
