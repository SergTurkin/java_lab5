import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab5 {

    public JButton Button11;
    public JPanel panel1;

    public lab5() {
        Button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello!");
            }
        });
    }

    public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    jFrame.setContentPane(new lab5().panel1);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
    }

}
