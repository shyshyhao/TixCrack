package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        // write your code here
        SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date firstTime = null;
        try {
             firstTime = dateFormatter.parse("2016/11/05 00:56:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new DateTask(), firstTime, 60000);

    }
}
