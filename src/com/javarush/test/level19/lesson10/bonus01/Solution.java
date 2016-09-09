package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader1 = new FileReader(reader.readLine());
        FileReader fileReader2 = new FileReader(reader.readLine());
        reader.close();

        BufferedReader readFile1 = new BufferedReader(fileReader1);
        BufferedReader readFile2 = new BufferedReader(fileReader2);
        String line1, line2;
        List<String> fileList1 = new ArrayList<>();
        List<String> fileList2 = new ArrayList<>();
        while ((line1 = readFile1.readLine()) != null)
        {
            fileList1.add(line1);
        }
        while ((line2 = readFile2.readLine()) != null)
        {
            fileList2.add(line2);
        }
        readFile1.close();
        readFile2.close();

        fileReader1.close();
        fileReader2.close();


        int i = 0, k = 0;
        while (i < fileList1.size() && k < fileList2.size())
        {

            if (fileList1.get(i).equals(fileList2.get(k)))
            {
                lines.add(new LineItem(Type.SAME, fileList1.get(i)));
                i++;
                k++;
                if (k == fileList2.size())
                {
                    while (i < fileList1.size())
                    {
                        lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                        i++;
                    }
                }
                if (i == fileList1.size())
                {
                    while (k < fileList2.size())
                    {
                        lines.add(new LineItem(Type.ADDED, fileList2.get(k)));
                        k++;
                    }
                }


            } else if (k + 1 < fileList2.size())
            {
                if (fileList1.get(i).equals(fileList2.get(k + 1)))
                {
                    lines.add(new LineItem(Type.ADDED, fileList2.get(k)));
                    k++;
                } else if (!fileList1.get(i).equals(fileList2.get(k + 1)))
                {
                    lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                    i++;
                }
            } else if (k + 1 >= fileList2.size())
            {
                if (i < fileList1.size())
                {
                    lines.add(new LineItem(Type.REMOVED, fileList1.get(i)));
                    i++;
                }
            }

        }


    }



    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }


    }
}
