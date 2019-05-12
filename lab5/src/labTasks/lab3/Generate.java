package labTasks.lab3;

import sample.Controller;

import java.util.Random;


class Generate {
    private static int stock = -1;

    synchronized void put(StringBuilder buf){
        Random rand = new Random();
        stock = rand.nextInt(100);
        buf.append(Thread.currentThread().getName()).append(" ").append(stock).append("\n");


        notify();
        try{
            wait();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized void get(StringBuilder buf, int i, int number)  {
        if (stock == -1){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        buf.append(Thread.currentThread().getName()).append(" ").append(stock).append("\n");
        if (i == number - 1){
            Controller.instance.resultTextBox.setText(buf.toString());
        }
        stock = -1;
        notify();
    }
}
