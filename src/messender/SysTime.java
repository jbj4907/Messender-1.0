package messender;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class SysTime {

    private Calendar today = Calendar.getInstance();

    private int nowHour = today.get(Calendar.HOUR_OF_DAY);
    private int nowMinute = today.get(Calendar.MINUTE);
    private int nowSecond = today.get(Calendar.SECOND);

    public void syncTime(){
                nowSecond++;
                if( nowSecond == 60){
                    nowMinute++;
                    nowSecond = 0;
                }
                if (nowMinute == 60){
                    nowHour++;
                    nowMinute = 0;
                }
                if (nowHour == 24) nowHour = 0;
    }

    public int nowHour() { return nowHour; }
    public int nowMinute() { return nowMinute; }
    public int nowSecond() { return nowSecond; }

}