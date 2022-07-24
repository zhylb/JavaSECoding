package com.exer1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * 输出一个日历表怎么做呢，还有就是将字符串转为 -》java.sql.Date
 *
 * 三天打渔两天晒网问题 ：从1900-1-1打渔，问xxxx-xx-xx是打渔还是晒网
 *
 * 1 不使用有关时间的类实现
 * 2 使用System.currentTimeMillis实现
 * 3 使用日期类实现
 *
 * 用了40多分钟，终于全实现了，开心
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/9 23:31
 */
public class DateQuestionTest {

    public static void main(String[] args) throws Exception{

        System.out.println(yearToYearDays(1900,3099));
        System.out.println(yearToYearDays2(1900,3099));

//        long newBee = newBee("2099-09-09");
//        long timeMillisIns = timeMillisIns("2099-09-09");
//        long calendarIns = calendarIns("2099-09-09");
//        boolean working = isWorking(newBee);
//
//        System.out.println("working = " + working);
//        System.out.println("newBee = " + newBee);
//        System.out.println("timeMillisIns = " + timeMillisIns);
//        System.out.println("calendarIns = " + calendarIns);
    }

    public static long newBee(String pattern){
        //首先获取数字的年月日
        String[] split = pattern.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        //计算月份带来的days
        int[] months = {0,31,28,31,30,31,30,31,31,30,31,30};//0月-11月，为了保持月份和角标的统一
        int monthDays = 0;
        for (int i = 1; i < month; i++) {
            monthDays += months[i];
        }

        //计算年份带来的days
        int yearDays = (int) yearToYearDays(1900,year);
        int days = yearDays + monthDays + day;

        //注意，如果今年是闰年并且月份大于 2需要+1天
        if(isLeapYear(year) && month > 2){
            days += 1;
        }
        return days;
    }


    public static long timeMillisIns(String pattern) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(pattern);
        Date begin = sdf.parse("1900-01-01");

        long ex = parse.getTime() - begin.getTime();
        long days = (ex / (1000*60*60*24)) + 1;
        return days;


    }

    public static long calendarIns(String pattern) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(pattern);
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);

        int dayOfYear = instance.get(Calendar.DAY_OF_YEAR);
        int year = instance.get(Calendar.YEAR);
        long days =  yearToYearDays(1900, year);
        days = days + dayOfYear;
        return days;
    }

    public static long yearToYearDays(int beginYear,int endYear){
        long days = 0;
        for (int i = beginYear; i < endYear; i++) {
            if(isLeapYear(i)){
                days += 1;
            }
        }
        days += (endYear - beginYear)* 365L;

        int a = (endYear - beginYear)/4 -1;


        return days;
    }

    public static long yearToYearDays2(int beginYear,int endYear){
        int su = endYear - beginYear;
        int year100 = su/100;
        int year400 = su/400;
        int year4 = su/4;
        int re = su*365 + year4 + year400*2 - year100;

        return re;
    }



    public static boolean isLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static boolean isWorking(long days){
        int day = (int) days;
        int mod = day % 5;
        if(mod > 0 && mod < 4) return true;
        else return false;
    }

}
