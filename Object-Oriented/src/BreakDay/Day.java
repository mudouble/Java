package BreakDay;

import java.time.LocalDate;

public class Day {
    private LocalDate day;
    private boolean flag;

    public Day(LocalDate day) {
        this.day = day;

    }

    public Day() {
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day=" + day +
                ", flag=" + flag +
                '}';
    }

    public void printBreakDay(){
        System.out.print(day);
        System.out.println(flag?": 休息日":"");
    }
}
