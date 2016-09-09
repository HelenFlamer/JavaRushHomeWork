package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileReader file = new FileReader(args[0]);
        Map<String, Double> map = new HashMap<>();
        BufferedReader read = new BufferedReader(file);
        String s;
        while ((s = read.readLine()) != null)
        {
            String[] p = s.split(" ");
            String name = p[0];
            Double count = Double.parseDouble(p[1]);

            if (map.containsKey(name))
            {
                Double value = map.get(name);
                value += count;
                map.remove(name);
                map.put(name, value);
            } else map.put(name, count);
        }
        file.close();
        read.close();
        List<String> list = new ArrayList<>();
        for (Map.Entry m : map.entrySet())
        {
            list.add(String.valueOf(m.getKey()));
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)
        {
            for (Map.Entry l : map.entrySet())
            {
                if (l.getKey().equals(list.get(i)))
                {
                    System.out.println(l.getKey() + " " + l.getValue());
                }
            }
        }
    }
}

