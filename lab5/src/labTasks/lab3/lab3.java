package labTasks.lab3;

import sample.Controller;

public class lab3 {
    public static void main(String[] args) {
        StringBuilder buf = new StringBuilder();
        try {
            if (args.length != 1) {
                Controller.instance.resultTextBox.setText("Incorrect number options");
                return;
            }
            Generate generate = new Generate();
            int col = Integer.parseInt(args[0]);
            new Manufacturer(generate, col, buf);
            new Consumer(generate, col, buf);

        } catch (Exception e) {
            Controller.instance.resultTextBox.setText("You must type positive integer number only!");
        }
    }
}
