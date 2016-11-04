package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hunter on 2016/11/5.
 */
public class TimestampUtils {
    public static String getTimestampStr() {
        SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2016-01-15 00:00:00
        String timestampStr = timestampFormat.format(new Date());

        return timestampStr;
    }

    public static String millisecondToTimeStr(long millisecond) {
        Date date = new Date(millisecond);
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS");
        String timestampStr = formatter.format(date);

        return timestampStr;
    }
}
