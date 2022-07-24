package com.lihd1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * java8日期时间api
 * 1 ZoneOffset - 关于时区的 点到为止
 * 2 LocalDateTime - Calendar
 * 3 Instant - Date instant （返回时间会有时区的问题）
 * 4 DateTimeFormatter - SimpleDateFormat
 *
 *
 *
 *
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/3/10 9:43
 */
public class DateTime8Test {


    /**
     * Test03 : DateTimeFormatter
     *
     * LocalDateTime等类实现了 TemporalAccessor接口
     *
     * 1 实例化 ：
     *      1.1 DateTimeFormatter.ISO_XXX_XXX
     *      1.2 DateTimeFormatter.ofLocalizedDateTime(FormatStyle.XXX)
     *      1.3 DateTimeFormatter.ofPattern("xxx")
     *
     * 2 方法
     *      2.1 格式化 ：String -> TemporalAccessor dateTimeFormatter.format(TemporalAccessor)
     *      2.2 解析 ： TemporalAccessor -> String dateTimeFormatter.parse(String)
     *
     */
    @Test
    public void test03 (){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);

        TemporalAccessor parse = dateTimeFormatter.parse("2022-08-10T10:20:37.392396");
        System.out.println(parse);

        LocalDateTime now = LocalDateTime.now();
        //System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(now)); 报错
        //System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(now));

        //System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL).format(now));
        //System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(now));


        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(now));


        //似乎分不清早上下午
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = formatter.format(now.plusHours(5));
        System.out.println(format1);
        //解析
        TemporalAccessor parse1 = formatter.parse("2022-03-10 03:30:28");
        System.out.println(parse1);


    }





    /**
     * Test02 : Instant (是utc时间，与北京时间相差8小时)
     * 1 实例化 ：
     *      1.1 Instant.now()
     *      1.2 Instant.ofEpochMilli(long milli)
     * 2 方法 ：
     *      2.1 offsetDateTime(ZoneOffset) -> 消除时区
     *      2.2 toEpochMilli() 转换为 milli
     *
     *
     *
     */
    @Test
    public void test02 (){
        Instant now = Instant.now();
        System.out.println(now);

        Instant instant = Instant.ofEpochMilli(new Date().getTime());
        System.out.println(instant);

        System.out.println(now.toEpochMilli());

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

    }







    /**
     * Test01 : LocalDateTime
     * 1 实例化 ：
     *     1.1 LocalDateTime.now()
     *     1.2 LocalDateTime.of()
     *
     * 2 方法 ：
     *     2.1 get
     *     2.2 with(set)
     *     2.3 plus(add)
     *     2.4 minus
     * 3 转换 ：
     *     3.1 datetime -> instant datetime.toInstant(ZoneOffset)
     *     3.2 instant -> datetime DateTime.ofInstant(instant,ZoneOffset)
     *
     */
    @Test
    public void test01 (){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localDate);

        LocalDateTime dream = LocalDateTime.of(2020, 5, 22, 8, 10, 50);
        System.out.println(dream);

        //get
        System.out.println(dream.getDayOfMonth());//22
        System.out.println(dream.getDayOfYear());//143
        System.out.println(dream.getMonth());//MAY

        //with （set） 返回一个新的对象，不可变性
        LocalDateTime withYear = dream.withYear(2022);
        System.out.println(withYear);

        LocalDateTime localDateTime = dream.withDayOfYear(245);
        System.out.println(localDateTime);

        //plus 加上负数好像没有关系
        LocalDateTime localDateTime1 = dream.plusMonths(5);
        System.out.println(localDateTime1);
        //minus 减去负数好像没有关系，但是应该不建议
        LocalDateTime localDateTime2 = dream.minusDays(-300);
        System.out.println(localDateTime2);

        System.out.println("----------------------------------");
        Instant instant = dream.toInstant(ZoneOffset.UTC);
        System.out.println(instant);


        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.systemDefault());
        System.out.println(localDateTime3);


    }


    /**
     * Test00 : ZoneOffset 时区 了解即可
     *
     *  ZoneId： 该类中包含了所有的时区信息， 一个时区的ID， 如 Europe/Paris
     *  ZonedDateTime： 一个在ISO-8601日历系统时区的日期时间， 如 2007-12-
     * 03T10:15:30+01:00 Europe/Paris。
     *  其中每个时区都对应着ID， 地区ID都为“ {区域}/{城市}” 的格式， 例如：
     * Asia/Shanghai等
     *
     *
     */
    @Test
    public void test00 (){
        // 指定区域，构造时间: 法国巴黎时间的当前时间，五月有DST，偏移量+2
        LocalDateTime now = LocalDateTime.of(LocalDate.of(2020, 5, 31), LocalTime.now());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(now, ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime.getOffset()); // +02:00

        // 手动调整的二月份，此时没有DST，偏移量是+1
        ZonedDateTime thirdMonth = zonedDateTime.minusMonths(3);
        System.out.println(thirdMonth.getOffset()); // +01:00
        //my-----------------------------------------------------------

        System.out.println(ZoneOffset.systemDefault());// Asia/Shanghai
        System.out.println(ZoneOffset.UTC);// Z

        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        System.out.println(zoneOffset);//+08:00


    }
}
