package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static boolean isDateOdd(String date)
    {

        Date today = new Date(date);
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
        if (dayCount % 2 == 0)
            return false;
        else
            return true;
    }
}
