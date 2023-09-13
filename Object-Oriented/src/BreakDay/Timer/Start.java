package BreakDay.Timer;

import java.util.Timer;

public class Start {
    public static void main(String[] args) {
        Timer time = new Timer();
        //schedule执行timeTask任务，延迟时间为0，间隔为1秒（1000毫秒）
        time.schedule(new TimeTask(),0,1000);
//        timeTask.run();

    }
}
