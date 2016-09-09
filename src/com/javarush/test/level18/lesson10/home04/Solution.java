package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
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
        FileInputStream file2 = new FileInputStream(name2);

        File tmpFile = File.createTempFile("tmpFile", ".txt", null);
        FileOutputStream tmp = new FileOutputStream(tmpFile);
        while (file1.available() > 0)
        {
            tmp.write(file1.read());
        }
        file1.close();
        tmp.close();

        FileInputStream tmpF = new FileInputStream(tmpFile);
        FileOutputStream file3 = new FileOutputStream(name1);
        while (file2.available() > 0)
        {
            file3.write(file2.read());
        }
        while (tmpF.available()>0){
            file3.write(tmpF.read());
        }


        file3.close();
        tmpF.close();
        file2.close();

    }
}
