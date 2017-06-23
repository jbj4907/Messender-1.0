package messender;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

public class MacroTimer extends SysTime {

    private String sendMsg;
    private boolean working;
    private int alertHour;
    private int alertMin;
    private int setMin;
    private int alertSecond;

    public void typingStr(String str) {

        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }

    // alertTIme 클래스 하나 만들어서 macrotimer 클래스에 상속.
    //

    public int runMin(int min) { // 1~2
        int alertTime;

        alertTime = nowMinute() + min;
        if (alertTime > 60) alertTime -= 60;

        alertSecond = nowSecond();

        return alertTime;
    }

    public void workSetup(int selected){
        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (working) {
                    if (selected == 1 && nowMinute() == alertMin && nowSecond() == alertSecond) {
                        typingStr(sendMsg);
                        working = false;
                    } else if (selected == 2 && nowMinute() == alertMin && nowSecond() == alertSecond) {
                        alertMin = runMin(setMin);
                        typingStr(sendMsg);
                    } else if (selected == 3 && nowMinute() == alertMin) typingStr(sendMsg);
                    else if (selected == 4 && nowHour() == alertHour && nowMinute() == alertMin) {
                        typingStr(sendMsg);
                        working = false;
                    }
                } else timer.cancel();
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public boolean getWorking() {
        return working;
    }

    public void setAlertHour(int alertHour) {
        this.alertHour = alertHour;
    }

    public void setAlertMin(int alertMin) {
        this.alertMin = alertMin;
    }

    public void setMin(int min) { this.setMin = min; }


}
