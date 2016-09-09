package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1= reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);
        String s = "";

        while (fileReader.ready()){
            s = s + (char) fileReader.read();
        }
        s = s.replace(".", "!");
        fileWriter.write(s);
        fileReader.close();
        fileWriter.close();
    }
}
