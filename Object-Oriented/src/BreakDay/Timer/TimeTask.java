package BreakDay.Timer;

import BreakDay.Day;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

//TimerTask用于定时执行任务的抽象类，需要实现其run()方法
public class TimeTask extends TimerTask {
    //高考开始时间
    private LocalDateTime startTime;
    //构造器，对高考开始时间进行初始化

    public TimeTask() {
        String s = "2024-06-07 09:00:00";
        //对时间进行解析，解析成LocalDateTime 时间中间有空格无法直接解析
        //需要调用DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        startTime = LocalDateTime.parse(s, dtf);
        System.out.println("\t\t\t2024高考倒计时");
        System.out.println("2024-06-07 星期五");
        System.out.println("距离高考还剩：");

    }

    @Override
    public void run() {
        //倒计时
        LocalDateTime now = LocalDateTime.now();
        //between计算两个时间段之间的时间
        Duration duration = Duration.between(now, startTime);
        //toDays是持续时间的天数部分，toHours是小时部分，是全部时间
//        System.out.println(duration.toDays()+" 天 "+ duration.toHours()+" 时 "+
//                duration.toMinutes()+" 分 "+duration.toSeconds()+"秒");
        //toDaysPart()
        System.out.println(duration.toDaysPart()+" 天 "+ duration.toHoursPart()+" 时 "+
                duration.toMinutesPart()+" 分 "+duration.toSecondsPart()+"秒");

    }
}
