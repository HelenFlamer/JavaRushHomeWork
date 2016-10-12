package com.javarush.test.level08.lesson11.home05;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by Dmitry on 29.06.2016.
 */
public class lowerCase
{
    public static void main(String[] args)
    {
        Date today = new Date("JANUARY 2 2020");
        Date start = new Date();
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        start.setDate(0);
        start.setMonth(0);
        start.setYear(today.getYear());
        long time = today.getTime() - start.getTime();
        long days = 24*60*60*1000;
        int dayCount = (int) (time/days) + 1;
        System.out.print(dayCount);


    }
}
