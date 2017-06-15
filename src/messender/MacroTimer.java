package messender;

import java.awt.Robot;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MacroTimer extends SysTime {
    private int interval;

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            plusOneSec();
        }
    };

}
