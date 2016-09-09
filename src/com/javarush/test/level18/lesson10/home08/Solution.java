package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String name = reader.readLine();
            if (name.equals("exit")) break;
            new ReadThread(name).start();
        }


    }

    public static class ReadThread extends Thread
    {
        public String fileName;

        public ReadThread(String fileName) throws IOException
        {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int[] mass = new int[256];
                while (fileInputStream.available() > 0)
                {
                    mass[fileInputStream.read()]++;
                }
                int max = mass[0];
                int needByte = 0;
                for (int i = 1; i < mass.length; i++)
                {
                    if (max < mass[i])
                    {
                        max = mass[i];
                        needByte = i;
                    }
                }
                resultMap.put(fileName, needByte);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
