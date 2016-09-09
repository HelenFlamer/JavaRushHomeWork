package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        List<String> list = new ArrayList<>();
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while ((line = read.readLine()) != null)
        {
            list.add(line);
        }
        read.close();

        String action = args[0];
        String enteredId = args[1];
        long id = 0;
        int index = -1;
        for (String s : list)
        {
            String currentLine = s.substring(0, 8);
            if (currentLine.charAt(7) != ' ')
            {
                id = Long.parseLong(currentLine);
            } else
            {
                currentLine = currentLine.substring(0, currentLine.indexOf(' '));
                id = Long.parseLong(currentLine);
            }
            if (enteredId.equals(String.valueOf(id)))
            {
                index = list.indexOf(s);
            }
        }
        if (action.equals("-d"))
        {

            if (index >= 0)
            {
                list.remove(index);
            }
        }
        if (action.equals("-u"))
        {
            String productName = args[2];
            String price = args[3];
            String quantity = args[4];
            while (enteredId.length() < 8)
            {
                enteredId = enteredId + " ";
            }

            while (productName.length() < 30)
            {
                productName = productName + " ";
            }
            while (price.length() < 8)
            {
                price = price + " ";
            }
            while (quantity.length() < 4)
            {
                quantity = quantity + " ";
            }
            String totalString = enteredId + productName + price + quantity;
            if (index >= 0)
            {
                list.set(index, totalString);
            }
        }
        FileWriter file = new FileWriter(fileName);
        for (String s: list){
            s = s +"\n";
            file.write(s);
        }
        file.close();
    }
}
