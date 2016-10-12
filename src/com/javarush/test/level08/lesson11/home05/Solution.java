package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer buffer = new StringBuffer(reader.readLine());

        char temp1 = buffer.charAt(0);
        String temp = "" + temp1;
        if (temp1 != ' ')
        {
            temp = temp.toUpperCase();
            buffer = buffer.replace(0, 1, temp);

        }

        for (int i=0; i<buffer.length()-1; i++){

            if ((buffer.charAt(i) == ' ') && (buffer.charAt(i+1) != ' ')){
                String symbol = "" + buffer.charAt(i+1);
                symbol = symbol.toUpperCase();
                buffer = buffer.replace(i+1, i+2, symbol);
            }
        }

        System.out.println(buffer);
    }


}
