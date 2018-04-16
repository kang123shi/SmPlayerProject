package com.ksm.smplayerproject.Tool;

import java.util.Calendar;

/**
 * 创建日期：2017/10/20 0020 on 16:36
 * 作者:arvin Administrator
 * 邮箱:it_xiaoshuai@163.com
 * 描述:
 */

public class TimerUtil {

    public static String getTime(long second) {
        if (second < 10) {
            return "00:00:0" + second;
        }
        if (second < 60) {
            return "00:00:" + second;
        }
        if (second < 3600) {
            long minute = second / 60;
            second = second - minute * 60;
            if (minute < 10) {
                if (second < 10) {
                    return "00:"+"0" + minute + ":0" + second;
                }
                return "00:0" + minute + ":" + second;
            }
            if (second < 10) {
                return"00:"+ minute + ":0" + second;
            }
            return "00:"+minute + ":" + second;
        }
        long hour = second / 3600;
        long minute = (second - hour * 3600) / 60;
        second = second - hour * 3600 - minute * 60;
        if (hour < 10) {
            if (minute < 10) {
                if (second < 10) {
                    return "0" + hour + ":0" + minute + ":0" + second;
                }
                return "0" + hour + ":0" + minute + ":" + second;
            }
            if (second < 10) {
                return "0" + hour +":"+ minute + ":0" + second;
            }
            return "0" + hour +":"+ minute + ":" + second;
        }
        if (minute < 10) {
            if (second < 10) {
                return hour + ":0" + minute + ":0" + second;
            }
            return hour + ":0" + minute + ":" + second;
        }
        if (second < 10) {
            return hour +":"+ minute + ":0" + second;
        }
        return hour +":"+ minute + ":" + second;
    }

    public static long GetNowTime(){
        Calendar calendar = Calendar.getInstance();
        int i_second = calendar.get(Calendar.SECOND);
        int i_minute = calendar.get(Calendar.MINUTE);
        int i_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int remain_hour = 23-i_hour;
        int remain_minte = 59-i_minute;
        int remain_second = 60-i_second ;
        long new_remain_second = remain_hour*60*60+remain_minte*60+remain_second;
        return new_remain_second;
    }

}
