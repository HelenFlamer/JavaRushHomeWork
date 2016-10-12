package com.javarush.test.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Dmitry on 29.09.2016.
 */
public class FileParse
{
    public static void main(String[] args) throws IOException
    {

        FileReader fileRead = new FileReader("D:\\JavaTest\\link_changer.vbs");
        FileWriter fileWriter = new FileWriter("D:\\JavaTest\\link_changer_tabs.txt");
        Scanner scanner = new Scanner(fileRead);
        String line;
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            //line = line.trim();
            if (!line.equals("") && !line.equals(null) && !line.equals(" "))
            {
                line = line.replaceAll("\"", "\"\"");
                line = "\"" + line + "\"" + "\r\n";
                line = "Print #oFile,  " + line;
                fileWriter.write(line);
                fileWriter.flush();
            }
            //System.out.print(line);
        }

        fileRead.close();
        fileWriter.close();
    }
}
