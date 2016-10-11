package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        String line = "";
        while (scanner.hasNextLine())
        {
            line = line + " " + scanner.nextLine();
        }
        fileReader.close();
        scanner.close();
        if (line != null)
        {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length - 1; i++)
            {
                StringBuilder first = new StringBuilder(words[i]);
                for (int j = i + 1; j < words.length; j++)
                {
                    StringBuilder second = new StringBuilder(words[j]);
                    if (first.toString().equals(second.reverse().toString())&& !(second.toString()).equals(null) && !(second.toString()).equals(""))
                    {
                        Pair pair = new Pair();
                        pair.first = first.toString();
                        pair.second = second.reverse().toString();

                        if (result.size() == 0)
                        {
                            result.add(pair);
                        } else
                        {
                            int count = 0;
                            for (Pair p : result)
                            {
                                if ((p.toString()).equals(pair.toString()))
                                {
                                    count++;
                                }
                            }
                            if (count == 0)
                                result.add(pair);
                        }
                    }
                }
            }
        }
    }

    public static class Pair
    {
        String first;
        String second;

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}
