package messender;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by jbj on 2017. 6. 15..
 */
public class App extends MacroTimer {
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
    private JLabel nowTime;
    private JLabel workAlarm;

    int selected = 0;

    public App() {

        setGUITime();
        setWorking(false);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(getWorking()) { // 작동O
                    startBtn.setText("시작");
                    cancelWork();
                } else { // 작동X

                    if (selected == 1) {
                        int min = Integer.parseInt(text1AfterMin.getText());
                        setAlertMin(runMin(min));
                        setMin(min);
                    }
                    else if (selected == 2) {
                        int min = Integer.parseInt(text2LoopAfterMin.getText());
                        setAlertMin(runMin(min));
                        setMin(min);
                    }
                    else if (selected == 3) {
                        int min = Integer.parseInt(text3LoopMin.getText());
                        setAlertMin(min);
                    }
                    else if (selected == 4) {
                        setAlertMin(Integer.parseInt(text4UniqueMin.getText()));
                        setAlertHour(Integer.parseInt(text4UniqueHour.getText()));
                    } else JOptionPane.showMessageDialog(null, "작동시킬 명령을 올바르게 선택해 주세요.");

                    if (selected > 0) {
                        startBtn.setText("중지");
                        setWorking(true);
                        setSendMsg(context.getText());
                        workSetup(selected);
                    }
                }

            }
        });

        radio1AfterMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = 1;
                setGUIEnable(selected, radio1AfterMin.isSelected());
            }
        });

        radio2LoopAfterMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = 2;
                setGUIEnable(selected, radio2LoopAfterMin.isSelected());
            }
        });

        radio3LoopMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = 3;
                setGUIEnable(selected, radio3LoopMin.isSelected());
            }
        });
        radio4UniqueTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = 4;
                setGUIEnable(selected,radio4UniqueTime.isSelected());
            }
        });
    }

    public void setGUIEnable(int target, boolean enabled){
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
            text1AfterMin.setEnabled(enabled);
            label1AfterMin.setEnabled(enabled);
        } else if(target == 2){
            text2LoopAfterMin.setEnabled(enabled);
            label2LoopAfterMin.setEnabled(enabled);
        } else if(target == 3){
            text3LoopMin.setEnabled(enabled);
            label3LoopMin.setEnabled(enabled);
        } else if (target == 4) {
            text4UniqueMin.setEnabled(enabled);
            text4UniqueHour.setEnabled(enabled);
        } else {
            text1AfterMin.setEnabled(enabled);
            label1AfterMin.setEnabled(enabled);
            text2LoopAfterMin.setEnabled(enabled);
            label2LoopAfterMin.setEnabled(enabled);
            text3LoopMin.setEnabled(enabled);
            label3LoopMin.setEnabled(enabled);
            text4UniqueHour.setEnabled(enabled);
            text4UniqueMin.setEnabled(enabled);
            label4UniqueHour.setEnabled(enabled);
            label4UniqueMin.setEnabled(enabled);
        }
    }
    public void setGUITime(){
        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                syncTime();
                nowTime.setText("현재시간: " + nowHour() + "시 " + nowMinute() + "분" + nowSecond() + "초");
                if (!getWorking()) {
                    startBtn.setText("시작");
                    workAlarm.setText("현재 작동중이 아닙니다. 시작버튼을 눌러 작동시켜 주세요.");
                } else workAlarm.setText("작동중입니다. 채팅 입력란에 마우스를 한번 클릭해 주세요.");
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }
    public void cancelWork(){
        setWorking(false);
        setGUIEnable(0, true);
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
