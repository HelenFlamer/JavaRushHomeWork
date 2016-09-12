package com.javarush.test.level20.lesson02.task03;


import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream file = new FileInputStream(fileName);
        load(file);
        file.close();

    }

    public void save(OutputStream outputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            p.setProperty(key, value);
        }
        p.store(outputStream, null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception
    {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();
        property.load(inputStream);
        Enumeration enumeration = property.propertyNames();
        while (enumeration.hasMoreElements())
        {
            String key = (String) enumeration.nextElement();
            String value = property.getProperty(key);
            properties.put(key, value);
        }
        inputStream.close();

    }
}
