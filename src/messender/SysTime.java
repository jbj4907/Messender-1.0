package messender;

import java.util.Calendar;

public class SysTime {

    private Calendar today = Calendar.getInstance();

    private int nowHour = today.get(Calendar.HOUR_OF_DAY);
    private int nowMinute = today.get(Calendar.MINUTE);
    private int nowSecond = today.get(Calendar.SECOND);

    public int nowHour() { return nowHour; }
    public int nowMinute() { return nowMinute; }
    public int nowSecond() { return nowSecond; }

    public void plusOneSec(){

        nowSecond += 1;

        if( nowSecond == 60){
            nowMinute += 1;
            nowSecond = 0;
        }

        if (nowMinute == 60){
            nowHour += 1;
            nowMinute = 0;
        }

        if (nowHour == 24) nowHour = 0;

    }

}