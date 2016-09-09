package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
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

        List<Double> list = new ArrayList<>();
        for (Map.Entry m : map.entrySet())
        {
            list.add((Double) m.getValue());
        }

        Collections.sort(list);
            for (Map.Entry l : map.entrySet())
            {
                if (l.getValue().equals(list.get(list.size()-1)))
                {
                    System.out.print(l.getKey() + " ");
                }
            }

    }
}
