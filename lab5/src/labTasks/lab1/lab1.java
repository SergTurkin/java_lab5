package labTasks.lab1;

import sample.Controller;

public class lab1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            Controller.instance.resultTextBox.setText("Incorrect number options");
            return;
        }
        double result, op1, op2;
        try {
            op1 = Double.parseDouble(args[0]);
            op2 = Double.parseDouble(args[2]);

            switch (args[1]) {
                case "+":
                    result = op1 + op2;
                    Controller.instance.resultTextBox.setText("Addition = " + result);
                    break;
                case "-":
                    result = op1 - op2;
                    Controller.instance.resultTextBox.setText("Subtraction = " + result);
                    break;
                case "/":
                    result = op1 / op2;
                    Controller.instance.resultTextBox.setText("Division = " + result);
                    break;
                case "*":
                    result = op1 * op2;
                    Controller.instance.resultTextBox.setText("Multiplication = " + result);
                    break;
                default:
                    Controller.instance.resultTextBox.setText("Incorrect operation!");
            }
        } catch (Exception ex) {
            Controller.instance.resultTextBox.setText("Incorrect operation!");
        }
    }
}


