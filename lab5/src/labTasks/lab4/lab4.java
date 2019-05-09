package labTasks.lab4;


import javafx.application.Platform;

public class lab4 {


    private final static class currentThread extends Thread {
        static Integer currThread = 0;
        Object next;

        private int count;
        private int number;
        private boolean last = false;

        currentThread(int count, int number) {
            this.count = count;
            this.number = number;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < count; ++i) {
                    synchronized (this) {
                        while (number != currThread)
                            wait();
                        Platform.runLater(()->System.out.print(this.getName() + " "));
                        currThread++;
                        if (last) {
                            currThread = 0;
                            Platform.runLater(()->System.out.print("\n"));
                        }

                        synchronized (next) {
                            next.notify();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        int NumberOfThreads = Integer.parseInt(args[0]);
        int NumberOfLines = Integer.parseInt(args[1]);

        currentThread[] threads = new currentThread[NumberOfThreads];
        for (int i = 0; i < NumberOfThreads; i++) {
            threads[i] = new currentThread(NumberOfLines, i);
        }
        for (int i = 0; i < NumberOfThreads - 1; i++) {
            threads[i].next = threads[i + 1];
        }
        threads[NumberOfThreads - 1].last = true;
        threads[NumberOfThreads - 1].next = threads[0];

        for (int i = 0; i < NumberOfThreads; i++) {
            new Thread(threads[i]).start();
        }
    }
}