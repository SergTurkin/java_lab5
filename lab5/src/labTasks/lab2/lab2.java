package labTasks.lab2;


public class lab2 {
    public static void main(String[] args) {
        try {
            Product[] start = new Product[4];
            start[0] = new Book();
            start[1] = new Shoe();
            start[2] = new Toy();
            start[3] = new Picture();
            Product[] mas = new Product[Integer.parseInt(args[0])];
            System.out.println("All in massive:");
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                mas[i] = start[i % 4];
                System.out.println(mas[i].whoAmI());
            }
            System.out.println("--------------");
            System.out.println("Present type:");
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                if (mas[i] instanceof Present) {
                    Present present = (Present) mas[i];
                    System.out.println(present.it_can_be_presented());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
