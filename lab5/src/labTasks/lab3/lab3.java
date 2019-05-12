package labTasks.lab3;

import sample.Controller;

public class lab3 {
    public static void main(String[] args) {
        StringBuilder buf = new StringBuilder();
        StringBuilder fl = new StringBuilder();
        try {

            Generate generate = new Generate();
            int col = Integer.parseInt(args[0]);
            new Manufacturer(generate, col, buf, fl);
            new Consumer(generate, col, buf, fl);

            while (fl.length() < 2) {
                System.out.println("Length :" + fl.length());

            }
            Controller.instance.resultTextBox.setText(buf.toString());
        } catch (Exception e) {
            Controller.instance.resultTextBox.setText("You must type positive integer number only!");
        }
    }
}
