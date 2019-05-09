package labTasks.lab2;

public class Toy implements Present, Product{
    public String whoAmI() {
        return ("I am a Toy");
    }
    public String it_can_be_presented() {
        return ("Toy can be presented");
    }
}
