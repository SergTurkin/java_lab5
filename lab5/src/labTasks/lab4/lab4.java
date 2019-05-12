package labTasks.lab4;


import sample.Controller;

public class lab4 {


    private final static class currentThread extends Thread {
        static Integer currThread = 0;
        static StringBuilder buf = new StringBuilder();
        Object next;

        private int count;
        private int number;
        private boolean last = false;

        String getName(int number){
            return "Thread-" + number;
        }
        currentThread(int count, int number, StringBuilder buf) {
            currentThread.buf = buf;
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
                        buf.append(getName(number)).append(" ");
                        currThread++;
                        if (last) {
                            currThread = 0;

                            buf.append("\n");
                        }

                        synchronized (next) {
                            next.notify();
                        }
                    }
                }
                if (last)
                    Controller.instance.resultTextBox.setText(buf.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {

            if (args.length != 2) {
                Controller.instance.resultTextBox.setText("Incorrect number options");
                return;
            }
            StringBuilder buf = new StringBuilder();
            int NumberOfThreads = Integer.parseInt(args[0]);
            int NumberOfLines = Integer.parseInt(args[1]);

            currentThread[] threads = new currentThread[NumberOfThreads];
            for (int i = 0; i < NumberOfThreads; i++) {
                threads[i] = new currentThread(NumberOfLines, i, buf);
            }
            for (int i = 0; i < NumberOfThreads - 1; i++) {
                threads[i].next = threads[i + 1];
            }
            threads[NumberOfThreads - 1].last = true;
            threads[NumberOfThreads - 1].next = threads[0];

            for (int i = 0; i < NumberOfThreads; i++) {
                new Thread(threads[i]).start();
            }
        } catch (Exception e){
            Controller.instance.resultTextBox.setText("Incorrect format!");
        }
    }
}