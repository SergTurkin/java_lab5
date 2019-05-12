package labTasks.lab3;


public class Consumer extends Thread {
    static StringBuilder buf = new StringBuilder();
    private Generate generate;
    private int number;
    static StringBuilder fl = new StringBuilder();

    Consumer(Generate generate, int m, StringBuilder buf, StringBuilder fl) {
        this.generate = generate;
        number = m;
        Consumer.buf = buf;
        Consumer.fl = fl;
        new Thread(this, "Потребитель -").start();
    }

    public void run() {
        for (int i = 0; i < number; i++) {
            generate.get(buf, fl, i ,number);
        }
    }
}
