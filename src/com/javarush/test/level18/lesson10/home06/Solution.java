package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] ascii = new int[256];

        while (fileInputStream.available() > 0)
        {
            ascii[fileInputStream.read()]++;
        }
        for (int i = 0; i < ascii.length; i++)
        {
            if (ascii[i] != 0)
            {
                System.out.println((char) i + " " + ascii[i]);
            }
        }
        fileInputStream.close();
    }
}
