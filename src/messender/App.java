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
    private JPanel radioPanel;
    private JPanel radio1;
    private JPanel radio2;
    private JPanel radio3;
    private JPanel radio4;
    private JPanel alertPanel;
    private JRadioButton radio1AfterMin;
    private JTextField text1AfterMin;
    private JRadioButton radio2LoopAfterMin;
    private JTextField text2LoopAfterMin;
    private JRadioButton radio3LoopMin;
    private JTextField text3LoopMin;
    private JRadioButton radio4UniqueTime;
    private JTextField text4UniqueHour;
    private JTextField text4UniqueMin;
    private JLabel label1AfterMin;
    private JLabel label2LoopAfterMin;
    private JLabel label3LoopMin;
    private JLabel label4UniqueHour;
    private JLabel label4UniqueMin;

    public App() {
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        radio1AfterMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGUIEnable(1, radio1AfterMin.isSelected());
            }
        });

        radio2LoopAfterMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGUIEnable(2, radio2LoopAfterMin.isSelected());
            }
        });

        radio3LoopMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGUIEnable(3, radio3LoopMin.isSelected());
            }
        });
        radio4UniqueTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGUIEnable(4,radio4UniqueTime.isSelected());
            }
        });
    }

    public void setGUIEnable(int target, boolean enabled){
        radio1AfterMin.setSelected(false);
        radio2LoopAfterMin.setSelected(false);
        radio3LoopMin.setSelected(false);
        radio4UniqueTime.setSelected(false);
        text1AfterMin.setEnabled(false);
        label1AfterMin.setEnabled(false);
        text2LoopAfterMin.setEnabled(false);
        label2LoopAfterMin.setEnabled(false);
        text3LoopMin.setEnabled(false);
        label3LoopMin.setEnabled(false);
        text4UniqueHour.setEnabled(false);
        text4UniqueMin.setEnabled(false);
        label4UniqueHour.setEnabled(false);
        label4UniqueMin.setEnabled(false);

        if(target == 1) {
            radio1AfterMin.setSelected(enabled);
            text1AfterMin.setEnabled(enabled);
            label1AfterMin.setEnabled(enabled);
        } else if(target == 2){
            radio2LoopAfterMin.setSelected(enabled);
            text2LoopAfterMin.setEnabled(enabled);
            label2LoopAfterMin.setEnabled(enabled);
        } else if(target == 3){
            radio3LoopMin.setSelected(enabled);
            text3LoopMin.setEnabled(enabled);
            label3LoopMin.setEnabled(enabled);
        } else {
            radio4UniqueTime.setSelected(enabled);
            text4UniqueHour.setEnabled(enabled);
            text4UniqueMin.setEnabled(enabled);
            label4UniqueHour.setEnabled(enabled);
            label4UniqueMin.setEnabled(enabled);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Messender");
        frame.setContentPane(new App().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
