package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Составить цепочку слов
//В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        Scanner scanner = new Scanner(fileReader);
        String line = "";
        while (scanner.hasNextLine())
        {
            line = line + " " + scanner.nextLine();
        }
        fileReader.close();
        scanner.close();
        line = line.trim();
        String[] words = line.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if (words.length == 0 || words == null)
            return new StringBuilder();

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        sb = variantsOfLine(0, words);

        return sb;


    }

    public static StringBuilder variantsOfLine(int changeParam, String... words)
    {
        List<String> tmpList = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (String s : words)
        {
            if (s != "" && s != null)
            {
                tmp.append(s + " ");
                tmpList.add(s);
            }
        }
        if (changeParam > 0)
        {
            Collections.shuffle(tmpList);
        }
        //tmpList.add(0, tmpList.get(changeParam));
        //tmpList.remove(changeParam+1);

        sb.append(tmpList.get(0));
        tmpList.set(0, "");
        int i = 1;
        while (sb.length() < tmp.length() - 1)
        {
            if (tmpList.get(i).length() > 0 && sb.substring(sb.length() - 1).toLowerCase().equals(tmpList.get(i).substring(0, 1).toLowerCase()))
            {
                sb.append(" " + tmpList.get(i));
                tmpList.set(i, "");

                for (String s : tmpList)
                {
                    if (s != "")
                    {
                        i = 0;
                        break;
                    }
                }
            }
            i++;
            if (sb.length() == tmp.length() - 1)
                break;

            if (i > tmpList.size() - 1 && changeParam < tmpList.size())
            {
                variantsOfLine(1, words);
            }

        }
        return sb;
    }
}
