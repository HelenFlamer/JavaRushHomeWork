package com.javarush.test.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitry on 12.09.2016.
 */
public class test
{
    public static void main(String [] args) throws IOException
    {

        FileReader file = new FileReader("D:\\JavaTest\\file.properties");
        String line = "";
        while (file.ready())
        {


            int symbol = file.read();
            line = line + (char) symbol;
            if (line.endsWith("\n") && (!(line.endsWith("\\\n")) || !(line.endsWith("\\\r\n"))))
            {
                Pattern pattern = Pattern.compile("(?<!\\\\)[!#].*");
                Matcher m = pattern.matcher(line);
                while (m.find()){
                    line=line.substring(0,m.start());
                    if (line.length()>0)
                    line = line+"\n";
                }
                System.out.print(line);

                line = "";
            }



        }
    }
}
