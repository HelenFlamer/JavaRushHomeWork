package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileReader file = new FileReader(name);
        String teg = args[0];

        String line = "";
        while (file.ready())
        {
            line = line + (char) file.read();
        }
        line = line.replaceAll("\n","");
        line = line.replaceAll("\r", "");
        file.close();

        String[] mass = line.split("<");
        List<String> tagList = new ArrayList<>();
        for (int i = 1; i < mass.length; i++)
        {
            tagList.add(mass[i]);
        }

        int tagStartCount = 0;
        int tagEndCount = 0;
        for (int i = 0; i < tagList.size(); i++)
        {
            if (tagList.get(i).startsWith(teg + ">") || tagList.get(i).startsWith(teg + " ") || tagList.get(i).startsWith(teg + "\r\n"))
            {
                int k = i;
                tagStartCount++;
                int j = i + 1;

                boolean param = true;
                while (param)
                {

                    if (tagList.get(j).startsWith(teg))
                        tagStartCount++;
                    else if (tagList.get(j).startsWith("/" + teg))
                    {
                        tagEndCount++;
                        if (tagStartCount == tagEndCount)
                        {

                            String endLine = "";
                            while (k <= j)
                            {
                                endLine = endLine + "<" + tagList.get(k);
                                k++;
                            }
                            System.out.println(endLine.substring(0, endLine.lastIndexOf("</" + teg + ">") + 3 + teg.length()));
                            tagEndCount = 0;
                            tagStartCount = 0;
                            param = false;
                        }
                    }
                    j++;
                }


            }
        }
    }

}


