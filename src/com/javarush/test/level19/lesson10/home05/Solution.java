package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        String line;
        BufferedReader reader = new BufferedReader(fileReader);
        while ((line = reader.readLine())!=null){
            String[] mass = line.split(" ");
            for (int i=0;i<mass.length; i++){
                if (mass[i].matches(".*\\d.*")){
                    fileWriter.write(mass[i]+" ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
