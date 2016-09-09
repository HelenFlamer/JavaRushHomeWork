package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);

        String string = "";
        int code;
        int flag = 0;

        while (fileReader.ready())
        {
            code = fileReader.read();
            string = string + (char) code;
        }
        String[] array = string.split(" ");
        for (int i = 0; i < array.length; i++)
        {
            flag = 0;
            for (int j = 0; j < array[i].length(); j++)
            {
                if (array[i].charAt(j) < 48 || array[i].charAt(j) > 57)
                {
                    flag++;
                }
            }
            if (flag == 0)
            {
                fileWriter.write(array[i] + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
