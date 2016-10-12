package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        //номера позиций чисел в массиве
        ArrayList<Integer> numbersPosition = new ArrayList<>();
        ArrayList<Integer> stringPosition = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                numbersPosition.add(i);
            } else stringPosition.add(i);
        }


        //сортируем числа
        for (int i = 0; i < numbersPosition.size()-1; i++)
        {
            for (int j = 0; j < numbersPosition.size() - i-1; j++)

            {
                int a = Integer.parseInt(array[numbersPosition.get(j + 1)]);
                int b = Integer.parseInt(array[numbersPosition.get(j)]);


                if (a > b)
                {
                    String tnp = array[numbersPosition.get(j + 1)];
                    array[numbersPosition.get(j + 1)] = array[numbersPosition.get(j)];
                    array[numbersPosition.get(j)] = tnp;

                }
            }
        }

        for (int i = 0; i < stringPosition.size()-1; i++)
        {
            for (int j = 0; j < stringPosition.size() - i-1; j++)
            {
                String a = array[stringPosition.get(j)];
                String b = array[stringPosition.get(j + 1)];
                if (isGreaterThan(a, b))
                {
                    array[stringPosition.get(j + 1)] = a;
                    array[stringPosition.get(j)] = b;


                }
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
