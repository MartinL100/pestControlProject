package com.AAAAAA.pestcontrolproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    private static long code;

    private static long voucherCode;

    public static String getDateString(String style) {
        SimpleDateFormat spf = new SimpleDateFormat(style);
        try {
            // URL url = new URL("http://www.bjtime.cn");
            // URLConnection uc = url.openConnection();// 生成连接对象
            // uc.connect(); // 发出连接
            // long ld = uc.getDate(); // 取得网站日期时间（时间戳）
            Date date = new Date(); // 转换为标准时间对象
            return spf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spf.format(new Date());
    }

    /**
     * 获取网络时间，1为精确到天，2为精确到小时，3为精确到分，4为精确到秒
     * 
     * @param type
     * @return
     */
    public static String getInternateDate(String type) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8")); // 时区设置
        try {
            // URL url = new URL("http://www.bjtime.cn");
            // URLConnection uc = url.openConnection();// 生成连接对象
            // uc.connect(); // 发出连接
            // long ld = uc.getDate(); // 取得网站日期时间（时间戳）
            Date date = new Date(); // 转换为标准时间对象
            if ("1".equals(type)) {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            } else if ("2".equals(type)) {
                return new SimpleDateFormat("yyyy-MM-dd HH").format(date);
            } else if ("3".equals(type)) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
            } else if ("4".equals(type)) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 获取标准的网络时间(date)
     */
    public static Date returnInternateDate() {
        try {
            // URL url = new URL("http://www.bjtime.cn");
            // URLConnection uc = url.openConnection();// 生成连接对象
            // uc.connect(); // 发出连接
            // long ld = uc.getDate(); // 取得网站日期时间（时间戳）
            Date date = new Date(); // 转换为标准时间对象
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取几天后的日期
     * 
     * @param date
     *            之前日期
     * @param days
     *            天数
     * @param style
     *            格式
     * @return 相加后的日期
     */
    public static String getAfterDate(Date date, int days, String style) {
        SimpleDateFormat df = new SimpleDateFormat(style);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + days);
        return df.format(calendar.getTime());
    }

    /**
     * 获取几天后的日期
     * 
     * @param date
     *            之前日期
     * @param days
     *            天数
     * @param style
     *            格式
     * @return 相加后的日期
     * @throws ParseException
     */
    public static String getAfterDate(String date, int days, String style) {
        SimpleDateFormat format = new SimpleDateFormat(style);
        Date dd = null;
        try {
            dd = format.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return format.format(calendar.getTime());
    }

    /**
     * 获取订单编号
     * 
     * @return
     */
    public static synchronized String getOrderCode() {
        code++;
        String str = getDateString("yyyyMMddHHmmss");
        long m = Long.parseLong((str)) * 1000;
        m += code;
        return String.valueOf(m);
    }



    public static void main(String[] args) {
        System.out.println(new DateUtils().getInternateDate("4"));
    }

    public static double convert(Double value) {
        if (value == null) {
            return 0;
        }
        long l1 = Math.round(value * 100); // 四舍五入
        double ret = l1 / 100.0; // 注意：使用 100.0 而不是 100
        return ret;
    }

    public static List<String> getWeekdays() {
        Calendar calendar = Calendar.getInstance();
        List<String> dates = new ArrayList<String>();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DATE, -1);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 7; i++) {
            dates.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }
}
