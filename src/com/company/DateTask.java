package com.company;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by hunter on 2016/11/5.
 */
public class DateTask extends TimerTask {

    @Override
    public void run() {

        //印出目前時間
        System.out.println("Task 執行時間：" + TimestampUtils.millisecondToTimeStr(System.currentTimeMillis()));

        OkHttpClient client = new OkHttpClient();

        String url = "https://tixcraft.com/activity/game/16_APINK";

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .build();

        Response response = null;
        String responseStr = "";
        try {
            response = client.newCall(request).execute();
            responseStr = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(responseStr);

    }
}
