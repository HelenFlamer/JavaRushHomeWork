package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int maximum = 0;
        int count = 0;


        while (count < N)
        {
            int a = Integer.parseInt(reader.readLine());
            if (count == 0) maximum = a;
            else
            {

                if (a >= maximum)
                    maximum = a;

            }
            count++;
        }

        System.out.println(maximum);
    }
}
