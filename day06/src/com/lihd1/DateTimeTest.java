package com.lihd1;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * java8之前日期时间api
 *
 * 1 System.currentTimeMillis()
 * 2 java.util.Date() java.sql.Date()
 * 3 SimpleDateFormat()
 * 4 Calendar()
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/9 15:18
 */
public class DateTimeTest {


    /**
     * Test04 : Calendar（抽象类） 日期类 可变对象（非常奇怪，日期都应该是不可变的）
     * 1 实例化的两个方法 ：
     *      1.1 Calendar.getInstance()
     *      1.2 new GregorianCalendar()
     * 2 常用方法 方法的使用会改变自己，因此部分方法没有返回值
     *      2.1 get(Calendar.XX_XX)
     *      2.2 set(Calendar.XX_XX, num)
     *      2.3 add(Calendar.XX_XX,-10)
     *      2.4 getTime() : calendar -> Date
     *      2.5 setTime(Date date) : Date -> calendar
     *
     *
     *
     */
    @Test
    public void test04 (){
        //1 实例化的两个方法 getInstance / new GregorianCalendar
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = new GregorianCalendar();
        System.out.println(instance);
        System.out.println(instance2);

        //2 常用方法
        //get
        int day_of_year = instance.get(Calendar.DAY_OF_YEAR);
        int day_of_week_in_month = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println("day_of_year = " + day_of_year);
        System.out.println("day_of_week_in_month = " + day_of_week_in_month);
        //set
        instance.set(Calendar.DAY_OF_MONTH,1);
        day_of_year = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println("day_of_year = " + day_of_year);

        //add 没有减去的方法不过add可以是负数
        instance.add(Calendar.WEEK_OF_YEAR,-1);
        day_of_year = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println("day_of_year = " + day_of_year);

        //getTime()
        Date time = instance.getTime();
        System.out.println(time);

        //setTime()
        instance.setTime(new Date());
        System.out.println(instance);


    }



    /**
     * Test03 : SimpleDateFormat
     * 格式化 ：Date -> String : sdf.format(Date)
     * 解析 ： String -> Date : sdf.parse(String s);
     *
     *
     */
    @Test
    public void test03 () throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat();
        //解析
        System.out.println(sdf.format(new Date()));

        //格式化
        Date parse = sdf.parse("2020/3/9 下午10:40");
        System.out.println(parse);

        System.out.println("-------------------------------------");
        SimpleDateFormat sdf1 = new SimpleDateFormat("曾经的你:yyyy-MM-dd hh:mm:ss");

        //解析
        System.out.println(sdf1.format(new Date()));

        String s = "曾经的你:2022-03-02 10:10:10";
        Date date = sdf1.parse(s);
        System.out.println(date);


    }



    /**
     * Test02 : 两个Date类
     * java.util.date
     *      |----- java.sql.date
     *
     * 两种构造器
     * 1 空参
     * 2 long time
     * 3 过时，使用年月日 (年份需要 -1900 ,月份需要+1，是真的难用)
     *
     * 两个方法的使用
     * toString() ：按照一定格式打印时间
     * getTime() ：返回时间戳
     *
     * 两个Date的互转
     *
     *
     */
    @Test
    public void test02 (){

        //1626883200000 这个时间是当时的时间呀，日后的你如果看到记得发现是第几天哦

        //两个构造器
        Date today = new Date();
        Date lday = new Date(1588521600000L);
        Date date = new Date(2020-1900,3 + 1,4);
        //两个方法
        System.out.println(today);
        System.out.println(date);
        System.out.println(lday);
        System.out.println(date.getTime());

        //java.sql.date的使用
        java.sql.Date sdate = new java.sql.Date(1588521600000L);
        java.sql.Date sdate2 = new java.sql.Date(2021-1900,5+1,22);
        System.out.println(sdate);
        System.out.println(sdate2);
        System.out.println(sdate.getTime());
        System.out.println(sdate2.getTime());

        //两个Date 的互转
        //1 sql -> util 子类转父类，多态即可
        Date a = sdate;

        //2 util -> SQL 父类转子类，需要一些操作 即getTime方法即可
        java.sql.Date b = new java.sql.Date(new Date().getTime());

    }



    /**
     * Test01 : System类中
     * System.currentTimeMillis()返回当前时间距离1970年1月1日的时间的毫秒数，又称为时间戳
     * 通常用于计算时间之差
     */
    @Test
    public void test01 (){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }
}
