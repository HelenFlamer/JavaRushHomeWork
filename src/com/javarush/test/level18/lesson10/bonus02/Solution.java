package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        List<Long> list = new ArrayList<>();
        FileInputStream readFile = new FileInputStream(fileName);
        BufferedReader read = new BufferedReader(new InputStreamReader(readFile));
        String line;
        while ((line = read.readLine()) != null)
        {
            String currentLine = line.substring(0, 8);
            long id = 0;
            if (currentLine.charAt(7) != ' ')
            {
                id = Long.parseLong(currentLine);
            } else
            {
                currentLine = currentLine.substring(0, currentLine.indexOf(' '));
                id = Long.parseLong(currentLine);
            }
            list.add(id);
        }
        read.close();
        readFile.close();
        Collections.sort(list);

        long identificator = list.get(list.size() - 1);
        identificator++;
        String id = String.valueOf(identificator);

        while (id.length() < 8)
        {
            id = id + " ";
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

        String totalString =id + productName + price + quantity+"\n";

        FileWriter writeFile = new FileWriter(fileName,true);
        writeFile.write(totalString);
        writeFile.close();
    }
}
