package com.xiaodongchu.component.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/14.
 */
public class DateUtil {
    private static final DateFormat DATE_FROMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间转成"yyyy-MM-dd"格式的字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return null;
        }
        return DATE_FROMAT.format(date);
    }
}