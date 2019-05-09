package labTasks.lab2;

public class Picture implements Present, Product{
    public String whoAmI() {
        return ("I am a Picture");
    }
    public String it_can_be_presented() {
        return ("Picture can be presented");
    }
}

