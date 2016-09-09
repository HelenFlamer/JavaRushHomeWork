package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileReader file = new FileReader(name);
        String word = "";
        long count = 0;
        int code;
        while (file.ready())
        {
            code = file.read();
            if (code > 96 && code < 123)
            {
                word = word + (char) code;
            }
            else
            {
                if (word.equals("world"))
                {
                    count++;
                }
                word = "";
            }
        }
        System.out.println(count);
        file.close();
    }
}
