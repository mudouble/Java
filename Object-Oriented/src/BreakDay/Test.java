package BreakDay;

import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //找出起始日子到目标月份的全部日子
        LocalDate startDay = LocalDate.of(2022,2,3);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的年份和月份，以便为你展示该月的休息日（注意：必须是2022-02月开始或之后）");
        String currentDate = sc.next()+"-01";

        LocalDate endDate = LocalDate.parse(currentDate);
        LocalDate endMothFistDate = endDate;
        //plusMoths是将月份增加一个，minusDays是将天数减去一天，这样就得到一个月的最后一天
        endDate = endDate.plusMonths(1).minusDays(1);
        //startDay-endDay的全部日子
        List<Day> days = new ArrayList<>();
        while(!startDay.isAfter(endDate)){
            Day day = new Day(startDay);
            days.add(day);
            startDay = startDay.plusDays(1);
        }
        System.out.println("全部日子： "+ days);

        //标记是否休息
        for (int i = 0; i < days.size(); i+=3) {
            Day day = days.get(i);
            day.setFlag(true);
        }

        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i).toString());
        }

        //展示当月休息的情况
        System.out.println("当月休息的情况： ");
        List<Day> currentDay = new ArrayList<>();
        for (int i = 0; i < days.size(); i++) {
            Day day = days.get(i);
            if (day.getDay().isBefore(endMothFistDate)){
                continue;
            }
            currentDay.add(day);
            day.printBreakDay();
        }
//        System.out.println(currentDayRest);

        //找出当月那些休息日是周末
        //steam转换成流

         /**
         * 使用Stream API可以将操作链式地连接在一起，将一系列的数据处理操作以清晰的方式表达出来，减少了临时变量的使用。
         * 延迟执行： Stream API支持延迟执行，只有在需要的时候才会执行操作。
         * filter 和 forEach 操作都是在流上执行的，只有在 forEach 被调用时，才会对集合元素进行遍历和操作。
         * 这种延迟执行可以提高效率，因为它允许跳过不必要的计算。
         * 并行处理： 如果有需要，你可以轻松地将Stream操作改为并行处理，以提高性能。
         * Stream API提供了并行流的支持，可以在多核处理器上并行执行操作，加速数据处理
         */

        currentDay.stream().filter(d->{
           return  (d.getDay().getDayOfWeek().getValue()==6|| d.getDay().getDayOfWeek().getValue()==7)&&d.isFlag();
                }).forEach(d->{
                    System.out.println(d+(d.getDay().getDayOfWeek().getValue()==6?"周六":"周日"));
                });

        //删掉return
        currentDay.stream().filter(d-> (d.getDay().getDayOfWeek().getValue()==6|| d.getDay().getDayOfWeek().getValue()==7)&&d.isFlag()
        ).forEach(d->{
            System.out.println(d+(d.getDay().getDayOfWeek().getValue()==6?"周六":"周日"));
        });

    }
}
