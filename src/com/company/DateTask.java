package com.company;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.TimerTask;

/**
 * Created by hunter on 2016/11/5.
 */
public class DateTask extends TimerTask {

    final static String HOST = "https://tixcraft.com/";

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


        Document doc = Jsoup.parse(responseStr);

        Elements links = doc.select("td input");

        for (Element link : links) {
            String linkHref = HOST + link.attr("data-href");

            System.out.println("連結: " + linkHref);

            String command = String.format("start chrome %1$s", linkHref);
            try {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", command});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
