package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static void main(String[] args) throws Exception {
        String str = "2022-05-16 23:59:59";

        System.out.println("当前时间1:" + getNow());
        System.out.println("当前时间2:" + getCurrentFormatDate(""));
        System.out.println("时间戳转换为日期:" + TimeStamp2Date("1610767666401",""));
        System.out.println("日期转换为时间戳：" + date2TimeStamp(str));
        System.out.println("计算两个日期之间相差的天数：" + daysBetween(new SimpleDateFormat("yyyyMMdd").parse("20210101"),new Date())); //将字符串转换为Date类型
    }


    /**
     * 获取指定格式的当前时间
     *
     * @param formats
     * @return String
     */
    public static String getCurrentFormatDate(String formats) {
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyyMMddHHmmss";
        }
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(formats);
        return dateFormat.format(date);
    }

    public static String getNow() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
//        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    }

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     *
     * @param timestampString 时间戳 如："1473048265";
     * @param formats         要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (StringUtils.isBlank(timestampString)) {
            return null;
        }
        if (TextUtils.isEmpty(formats)) {
            formats = "yyyy-MM-dd HH:mm:ss";
        }

        Long timestamp = null;
        if (timestampString.length() == 13) {
            timestamp = Long.parseLong(timestampString);
        } else {
            timestamp = Long.parseLong(timestampString) * 1000;
        }

        return new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
    }

    /**
     * 日期转换为时间戳
     * @param str
     * @return
     * @throws ParseException
     */
    public static String date2TimeStamp(String str) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        return String.valueOf(date.getTime());
    }


    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDate 较小的时间
     * @param endDate   较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static Integer daysBetween(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweenDays));
    }
}
