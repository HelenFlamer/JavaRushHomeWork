package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stroka = reader.readLine();
        int questionIndex = stroka.indexOf('?');
        StringBuffer string = new StringBuffer(stroka);
        stroka = string.substring(questionIndex + 1);
        String value = "";
        String[] arrayStrings = stroka.split("&");
        for (String n : arrayStrings)
        {
            int i = 0;
            String parametr = "";
            while (i < n.length())
            {
                if ((n.charAt(i)) != '=')
                {
                    parametr = parametr + n.charAt(i);
                    if (parametr.equals("obj") && n.charAt(i+1) == '=')
                    {
                        value = n.substring(i + 2);
                    }
                    i++;
                } else break;
            }
            System.out.print(parametr + " ");

        }
        System.out.println();
        if (value.length() > 0)
        {
            try
            {
                Double a = Double.parseDouble(value);
                alert(a);
            }
            catch (Exception e)
            {
                alert(value);
            }
            // if (value.contains("."))
            //  alert(Double.parseDouble(value));
            //  else alert(value);
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
