package labTasks.lab3;


public class Consumer extends Thread {
    private Generate generate;
    private int number;

    Consumer(Generate generate, int m) {
        this.generate = generate;
        number = m;
        new Thread(this, "Потребитель -").start();
    }

    public void run() {
        for (int i = 0; i < number; i++) {
            generate.get();
        }
    }
}
