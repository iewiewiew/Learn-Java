package basedemo;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8TimeDemo {

    public static void main(String[] args) {

        /**
         * 当天日期
         */
        LocalDate today = LocalDate.now();
        System.out.println("当天日期：" + today); //2021-12-27

        /**
         *处理特定日期
         */
        LocalDate birthday = LocalDate.of(1994, 8, 11);
        System.out.println("处理特定日期：" + birthday); //1994-08-11

        /**
         *日期比较
         */
        if (today.equals(birthday)) {
            System.out.println("日期相同：");
        } else {
            System.out.printf("日期不同：");
        }

        /**
         *MonthDay和YearMonth用来检查某一天是不是生日这种周期性时间
         */
        MonthDay myBithday = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay currentMonDay = MonthDay.from(today);
        System.out.printf("currentMonDay：" + currentMonDay + "\n");
        if (myBithday.equals(currentMonDay)) {
            System.out.printf("currentMonDay：" + currentMonDay);
            System.out.println("今天是你的生日");
        }

        /**
         *在现有时间基础上计算之前之后的年、月、周、时、分、秒
         */
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime afterTime = nowTime.plusHours(3);
        LocalDateTime beforeTime = nowTime.minusYears(2);
        System.out.println("afterTime: " + afterTime + "----------beforeTime: " + beforeTime); //afterTime:2021-12-27T17:56:23.172----------beforeTime:2019-12-27T14:56:23.172

        /**
         * 在现有时间基础上修改年、月、周、时、分、秒
         */
        LocalDateTime localDateTime = nowTime.withHour(1);
        System.out.println("with 1 Time: " + localDateTime); //with 1 Time: 2021-12-27T01:00:43.596

        /**
         * 使用java8的Clock时钟类获取时间戳
         */
        Clock clock = Clock.systemUTC();
        System.out.println("clock.millis()：" + clock.millis()); // 1590811768013
        System.out.println("System.currentTimeMillis()：" + System.currentTimeMillis()); // 1590811768013

        Clock defalutClock = Clock.systemDefaultZone();
        System.out.println("defalutClock.millis()：" + defalutClock.millis()); // 1590811768013
        System.out.println("defalutClock.millis()：" + defalutClock.getZone()); // Asia/Shanghai

        /**
         * 判断早于某时还是晚于某时
         */
        LocalDateTime tomorrow = nowTime.plusDays(1);
        if (tomorrow.isEqual(nowTime)) {
            //时间一样
        } else if (tomorrow.isAfter(nowTime)) {
            //是否在当前之后
        } else if (tomorrow.isBefore(nowTime)) {
            //之前
        } else {
            //
        }

        /**
         * 时区处理
         */
        ZoneId beijing = ZoneId.of("America/New_York");
        LocalDateTime timenow = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(timenow, beijing);
        System.out.println("纽约时间" + zonedDateTime); //纽约时间2020-05-30T12:22:38.102-04:00[America/New_York]

        /**
         * 检测闰年
         */
        LocalDate leafYear = LocalDate.now();
        if (leafYear.isLeapYear()) {
            //闰年
        }

        /**
         * 计算两个时间之间的天数和月数
         */
        LocalDate current = LocalDate.now();
        LocalDate yourBirthday = LocalDate.of(1996, 8, 11);
        Period between = Period.between(yourBirthday, current);
        System.out.println("计算两个时间之间的天数和月数：" + between.getYears() + "年" + between.getMonths() + "月" + between.getDays() + "天");

        /**
         * 包含时差信息的日期和时间
         * ZoneOffset 表示时差 印度与GMT或者UTC飙车事件时差+5:30
         */
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, offset);
        System.out.println("offsetDateTime：" + offsetDateTime); //2020-05-30T12:48:54.655+05:30
        System.out.println("OffsetDateTime.now()：" + OffsetDateTime.now()); //2020-05-30T12:48:54.655+08:00

        /**
         * 格式化时间
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("formatter.format(LocalDateTime.now())：" + formatter.format(LocalDateTime.now()));//2020-05-30 12:55:40
    }
}