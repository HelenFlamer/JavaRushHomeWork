package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileInputStream file1 = new FileInputStream(name1);
        FileWriter file2 = new FileWriter(name2);
        BufferedReader read = new BufferedReader(new InputStreamReader(file1));
        {
            String line;
            String newLine = "";
            while ((line = read.readLine()) != null)
            {
                String[] mass = line.split(" ");
                for (int i = 0; i<mass.length; i++){
                    mass[i] = String.valueOf(Math.round(Float.parseFloat(mass[i])));
                }
                for (String m : mass){
                    newLine = newLine + m + " ";
                }
                newLine = newLine  + "\n";
                file2.write(newLine);
                newLine="";

            }
        }
        file1.close();
        file2.close();
        read.close();
    }
}