package labTasks.lab3;


public class Consumer extends Thread {
    static StringBuilder buf = new StringBuilder();
    private Generate generate;
    private int number;

    Consumer(Generate generate, int m, StringBuilder buf) {
        this.generate = generate;
        number = m;
        Consumer.buf = buf;
        new Thread(this, "Потребитель -").start();
    }

    public void run() {
        for (int i = 0; i < number; i++) {
            generate.get(buf, i ,number);
        }
    }
}
