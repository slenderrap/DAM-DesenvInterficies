package com.project;

import java.util.Calendar;

public class GameData {

    public double hores = 0;
    public double minuts = 0;
    public double segons = 0;
    public double millis = 0;

    public void run() {
        Calendar cal = Calendar.getInstance();
        this.hores = cal.get(Calendar.HOUR_OF_DAY);
        this.minuts = cal.get(Calendar.MINUTE);
        this.segons = cal.get(Calendar.SECOND);
        this.millis = cal.get(Calendar.MILLISECOND);
    }
}
