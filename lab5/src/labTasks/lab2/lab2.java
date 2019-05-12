package labTasks.lab2;


import sample.Controller;

public class lab2 {
    public static void main(String[] args) {
        try {
            StringBuilder buf = new StringBuilder();
            Product[] start = new Product[4];
            start[0] = new Book();
            start[1] = new Shoe();
            start[2] = new Toy();
            start[3] = new Picture();
            Product[] mas = new Product[Integer.parseInt(args[0])];
            buf.append("All in massive:\n");
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                mas[i] = start[i % 4];
                buf.append(mas[i].whoAmI()).append("\n");
            }
            buf.append("--------------\n");
            buf.append("Present type:\n");
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                if (mas[i] instanceof Present) {
                    Present present = (Present) mas[i];
                    buf.append(present.it_can_be_presented()).append("\n");
                }
            }
            Controller.instance.resultTextBox.setText(buf.toString());
        } catch (Exception ex) {
            Controller.instance.resultTextBox.setText("Incorrect operation!");
        }
    }
}
