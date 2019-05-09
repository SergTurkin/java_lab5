package labTasks.lab1;

public class lab1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Incorrect number options");
        }
        double result, op1, op2;
        try {
            op1 = Double.parseDouble(args[0]);
            op2 = Double.parseDouble(args[2]);

            switch (args[1]) {
                case "+":
                    result = op1 + op2;
                    System.out.println("Addition = " + result);
                    break;
                case "-":
                    result = op1 - op2;
                    System.out.println("Subtraction = " + result);
                    break;
                case "/":
                    result = op1 / op2;
                    System.out.println("Division = " + result);
                    break;
                case "*":
                    result = op1 * op2;
                    System.out.println("Multiplication = " + result);
                    break;
                default:
                    System.out.println("Incorrect operation!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


