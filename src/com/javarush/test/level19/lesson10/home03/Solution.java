package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        FileReader file = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(file);
        String line;
        while ((line = reader.readLine()) != null)
        {
            String[] mass = line.split(" ");
            int date = Integer.parseInt(mass[mass.length - 3]);
            int month = Integer.parseInt(mass[mass.length - 2]);
            int year = Integer.parseInt(mass[mass.length - 1]);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date dateB = format.parse(date+"."+month+"."+year);
            int i = 1;
            String name = mass[0];
            while (i < mass.length - 3){
                name =name + " "+ mass[i];
            i++;}

            PEOPLE.add(new Person(name, dateB));
        }
        reader.close();
        file.close();
    }

}
