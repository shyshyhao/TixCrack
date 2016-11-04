package com.company;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by hunter on 2016/11/5.
 */
public class DateTask extends TimerTask {

    @Override
    public void run() {

        //印出目前時間
        System.out.println("Task 執行時間：" +TimestampUtils.millisecondToTimeStr(System.currentTimeMillis()));
    }
}
