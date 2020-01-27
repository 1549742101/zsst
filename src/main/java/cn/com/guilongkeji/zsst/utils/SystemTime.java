package cn.com.guilongkeji.zsst.utils;

import lombok.SneakyThrows;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/13
 */
public class SystemTime extends Thread{

    int year;
    int mouth;
    int day;
    int hour;
    int minute;
    int s;
    Long t=0L;
    @Override
    public void run() {
        System.out.println("执行了run方法"+this.t);
        t++;
        year= (int) (t/(365*24*60*60));
        mouth = (int)(t-year*365*24*60*60)/(31*24*60*60);
        day = (int)(t-year*365*24*60*60-mouth*31*24*60*60)/(24*60*60);
        hour = (int)(t-year*365*24*60*60-mouth*31*24*60*60-day*24*60*60)/(60*60);
        minute = (int)(t-year*365*24*60*60-mouth*31*24*60*60-day*24*60*60-hour*60*60)/(60);
        s = (int)(t-year*365*24*60*60-mouth*31*24*60*60-day*24*60*60-hour*60*60-minute*60);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public Long getT() {
        return t;
    }

    public void setT(Long t) {
        this.t = t;
    }
}
