package com.jdk8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class DateTimeTest {

    public static void main(String[] args) {

//一个时间表示
        String stringDate = "2020-01-02 22:00:00";
//初始化三个时区
        ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        ZoneId timeZoneNY = ZoneId.of("America/New_York");
        ZoneId timeZoneJST = ZoneOffset.ofHours(9);
//格式化器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
//使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区,不推荐
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println(timeZoneSH.getId() + outputFormat.withZone(timeZoneSH).format(date));
        System.out.println(timeZoneNY.getId() + outputFormat.withZone(timeZoneNY).format(date));
        System.out.println(timeZoneJST.getId() + outputFormat.withZone(timeZoneJST).format(date));


//使用刚才定义的DateTimeFormatterBuilder构建的DateTimeFormatter来解析这个时间
        LocalDateTime localDateTime = LocalDateTime.parse("2020-01-02 12:34:56", dateTimeFormatter);
//解析成功
        System.out.println(localDateTime.format(dateTimeFormatter));
//使用yyyyMM格式解析20160901是否可以成功呢？
//        String dt = "20160901";
//        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyyMM");
//        System.out.println("result:" + dateTimeFormatter2.parse(dt));

//        int 发生了溢出。修复方式就是把 30 改为 30L，让其成为一个 long：
        Date today = new Date();
        Date nextMonth = new Date(today.getTime() + 30L * 1000 * 60 * 60 * 24);
        System.out.println(today);
        System.out.println(nextMonth);

// jdk1.8 before
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println(c.getTime());

//jdk1.8 after
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2.plusDays(30));


        System.out.println("//本月的第一天");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println("//今年的程序员日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()).plusDays(255));

        System.out.println("//今天之前的一个周六");
        System.out.println(LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));

        System.out.println("//本月最后一个工作日");
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

//可以直接使用 lambda 表达式进行自定义的时间调整
        System.out.println(LocalDate.now().with(temporal -> temporal.plus(ThreadLocalRandom.current().nextInt(100), ChronoUnit.DAYS)));


//Java 8 中有一个专门的类 Period 定义了日期间隔，通过 Period.between 得到了两个 LocalDate 的差，
// 返回的是两个日期差几年零几月零几天。如果希望得知两个日期之间差几天，直接调用 Period 的 getDays() 方法得到的只是最后的“零几天”，
// 而不是算总的间隔天数。
        System.out.println("//计算日期差");
        LocalDate today1 = LocalDate.of(2019, 12, 12);
        LocalDate specifyDate = LocalDate.of(2019, 10, 1);
        System.out.println(Period.between(specifyDate, today1).getDays());
        System.out.println(Period.between(specifyDate, today1));
        System.out.println(ChronoUnit.DAYS.between(specifyDate, today1));

        Supplier<String> stringSupplier = ()->"OK";
    }
}
