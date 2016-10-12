package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. +
Заполнить его числами с клавиатуры. +
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] num = new int[20];
        for (int i = 0; i<20; i++){
            num[i] = Integer.parseInt(reader.readLine());
        }

        int  maximum;
        int  minimum;
        maximum =num[0];
        minimum = num[0];
        //напишите тут ваш код
        for (int i = 1; i<20; i++)
        {
            if (num[i] >= maximum)
                maximum = num[i];

            if (num[i] <= minimum)
                minimum = num[i];
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
