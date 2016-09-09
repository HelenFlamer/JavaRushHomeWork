package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        String line;
        int count = 0;
        BufferedReader reader = new BufferedReader(fileReader);
        while ((line = reader.readLine()) != null)
        {
            String[] mass = line.split(" ");
            for (int i = 0; i < mass.length; i++)
            {
                if (mass[i].length() > 6)
                {
                    if (count == 0)
                    {
                        fileWriter.write(mass[i]);
                        count++;
                    } else fileWriter.write("," + mass[i]);

                }
            }
        }
        fileReader.close();
        fileWriter.close();
        reader.close();

    }
}
