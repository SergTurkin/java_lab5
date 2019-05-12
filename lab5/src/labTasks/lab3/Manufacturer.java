package labTasks.lab3;


public class Manufacturer extends Thread {
    private static StringBuilder buf = new StringBuilder();
    private Generate generate;
    private int number;
    static StringBuilder fl = new StringBuilder();

    Manufacturer(Generate generate, int m, StringBuilder buf, StringBuilder fl) {
        this.generate = generate;
        number = m;
        Manufacturer.buf = buf;
        Manufacturer.fl = fl;
        new Thread(this, "Производитель -").start();
    }

    public void run() {
        for (int i = 0; i < number; i++) {
            generate.put(buf, fl, i ,number);
        }
    }
}
