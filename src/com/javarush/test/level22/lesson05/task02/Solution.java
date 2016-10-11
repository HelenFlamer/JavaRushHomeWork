package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {

        if (string == null)
            throw new TooShortStringException();
        else if (!string.contains("\t"))
            throw new TooShortStringException();
        else
        {
            int index1, index2;
            index1 = string.indexOf("\t");
            String s = string.substring(index1 + 1);
            index2 = s.indexOf("\t") + index1 + 1;
            if (index1 == index2)
                throw new TooShortStringException();
            if (index1 + 1 == index2)
                return "";
            else return string = string.substring(index1 + 1, index2);
        }
    }

    public static class TooShortStringException extends Exception
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
