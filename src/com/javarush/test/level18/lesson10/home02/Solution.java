package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        FileInputStream file = new FileInputStream(args[0]);
        long charCount = file.available();
        long spaceCount = 0;
        while (file.available() > 0)
        {
            if (file.read() == 32){
                spaceCount++;
            }
        }
        float var = (float) (spaceCount*100/charCount);
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(var);
        System.out.println(format);
        file.close();
    }
}
