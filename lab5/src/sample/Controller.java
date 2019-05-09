package sample;

import java.io.PrintStream;
import java.net.URL;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import labTasks.lab1.lab1;
import labTasks.lab2.lab2;
import labTasks.lab3.lab3;
import labTasks.lab4.lab4;



public class Controller {

    @FXML
    private RadioButton RBlab1;

    @FXML
    private RadioButton RBlab2;

    @FXML
    private RadioButton RBlab4;

    @FXML
    private RadioButton RBlab3;

    @FXML
    private Label tasklbl;

    @FXML
    private TextArea taskTextBox;

    @FXML
    private Label resultlbl;

    @FXML
    public  TextArea resultTextBox;

    private ToggleGroup group = new ToggleGroup();

    @FXML
    private Button startBtn;

    @FXML
    void initialize() {
        Console console = new Console(resultTextBox);
        PrintStream ps = new PrintStream(console, true);
        System.setOut(ps);
        System.setErr(ps);

        tasklbl.setVisible(false);
        taskTextBox.setVisible(false);
        resultlbl.setVisible(false);
        resultTextBox.setVisible(false);
        startBtn.setVisible(false);

        RBlab1.setToggleGroup(group);
        RBlab2.setToggleGroup(group);
        RBlab3.setToggleGroup(group);
        RBlab4.setToggleGroup(group);
    }


    public void turnTask() {
        if (this.group.getSelectedToggle().equals(this.RBlab1)) {
            taskTextBox.clear();
            tasklbl.setVisible(true);
            taskTextBox.setVisible(true);
            startBtn.setVisible(true);
            resultlbl.setVisible(false);
            resultTextBox.setVisible(false);
            tasklbl.setText("Введите арифметическое выражение (Пример: 2 * 5):");
        }
        if (this.group.getSelectedToggle().equals(this.RBlab2)) {
            taskTextBox.clear();
            tasklbl.setVisible(true);
            taskTextBox.setVisible(true);
            startBtn.setVisible(true);
            resultlbl.setVisible(false);
            resultTextBox.setVisible(false);
            tasklbl.setText("Введите количество объектов:");
        }
        if (this.group.getSelectedToggle().equals(this.RBlab3)) {
            taskTextBox.clear();
            tasklbl.setVisible(true);
            taskTextBox.setVisible(true);
            startBtn.setVisible(true);
            resultlbl.setVisible(false);
            resultTextBox.setVisible(false);
            tasklbl.setText("Введите количество генерирования производителем числа:");
        }
        if (this.group.getSelectedToggle().equals(this.RBlab4)) {
            taskTextBox.clear();
            tasklbl.setVisible(true);
            taskTextBox.setVisible(true);
            startBtn.setVisible(true);
            resultlbl.setVisible(false);
            resultTextBox.setVisible(false);
            tasklbl.setText("Введите количество потоков и строк(Пример: 4 5):");
        }
    }

    public void startTask() throws InterruptedException {
        if (!resultTextBox.isVisible()){
            resultTextBox.setVisible(true);
        }
        if (!resultlbl.isVisible()){
            resultlbl.setVisible(true);
        }


        if (this.group.getSelectedToggle().equals(this.RBlab1)) {
            resultTextBox.clear();
            String res = taskTextBox.getText();
            String[] str = res.split(" ");
            lab1.main(str);
        }
        if (this.group.getSelectedToggle().equals(this.RBlab2)) {
            resultTextBox.clear();
            String res = taskTextBox.getText();
            String[] str = res.split(" ");
            lab2.main(str);
        }
        if (this.group.getSelectedToggle().equals(this.RBlab3)) {
            resultTextBox.clear();
            String res = taskTextBox.getText();
            String[] str = res.split(" ");
            lab3.main(str);
        }
        if (this.group.getSelectedToggle().equals(this.RBlab4)) {
            resultTextBox.clear();
            String res = taskTextBox.getText();
            String[] str = res.split(" ");
            lab4.main(str);
        }

    }
}

