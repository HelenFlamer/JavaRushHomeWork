
package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        long count = 0;
        FileInputStream file = new FileInputStream(args[0]);
        while (file.available() > 0)
        {
            int ch = file.read();
            if (ch >= 97 && ch <= 122){//перевели к верхнему регистру
                ch = ch-32;
            }
            if (ch >= 65 && ch <= 90)
            {
                count++;
            }
        }
        System.out.println(count);
        file.close();
    }
}
