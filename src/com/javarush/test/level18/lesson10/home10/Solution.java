package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        while (true)
        {
            String namePart = reader.readLine();
            if (namePart.equals("end")) break;
            list.add(namePart);
        }
        reader.close();

        //создание файладля записи
        String tmpString = list.get(0);
        String deletePart = tmpString.substring(0, tmpString.lastIndexOf('.'));
        File outputFile = new File(deletePart);
        outputFile.createNewFile();
        FileOutputStream writeFile = new FileOutputStream(deletePart);

        Collections.sort(list);


        for (int i = 0; i < list.size(); i++)
        {
            FileInputStream readFile = new FileInputStream(list.get(i));
            while (readFile.available() > 0)
            {
                writeFile.write(readFile.read());
            }
            readFile.close();
        }
        writeFile.close();
    }
}
