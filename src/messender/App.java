package messender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jbj on 2017. 6. 15..
 */
public class App {
    private JButton startBtn;
    private JTextField context;
    private JPanel panel;
    private JPanel panelSender;
    private JRadioButton radioButton1;
    private JTextField textField1;

    public App() {
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Messender");
        frame.setContentPane(new App().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
