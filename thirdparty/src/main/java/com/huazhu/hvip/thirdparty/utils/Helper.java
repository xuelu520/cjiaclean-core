package com.huazhu.hvip.thirdparty.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Calendar;
import java.util.Date;

public class Helper {

    private static Logger logger = LogManager.getLogger(Helper.class);

    /**
     * 获取数据如果为null，返回""
     *
     * @param str
     * @return
     */
    public static String fixNull(String str) {
        if (str == null || str.equals("null") || str.equals("NULL")) {
            return "";
        }
        return str;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
