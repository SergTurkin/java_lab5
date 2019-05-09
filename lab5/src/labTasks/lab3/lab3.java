package labTasks.lab3;

public class lab3 {
    public static void main(String[] args) {
        try {
            Generate generate = new Generate();
            int col = Integer.parseInt(args[0]);
            new Manufacturer(generate, col);
            new Consumer(generate, col);
        } catch (Exception e) {
            System.out.println("You must type positive integer number only!");
        }
    }
}
