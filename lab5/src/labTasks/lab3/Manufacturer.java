package labTasks.lab3;


public class Manufacturer extends Thread {
    private Generate generate;
    private int number;

    Manufacturer(Generate generate, int m) {
        this.generate = generate;
        number = m;

        new Thread(this, "Производитель -").start();
    }

    public void run() {
        for (int i = 0; i < number; i++) {
          generate.put();
        }
    }
}
