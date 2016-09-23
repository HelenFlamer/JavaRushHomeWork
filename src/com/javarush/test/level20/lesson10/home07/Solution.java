package com.javarush.test.level20.lesson10.home07;

import java.io.*;


/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable
{
    private transient FileOutputStream stream;
    private String fileName;

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FileOutputStream fileOut = new FileOutputStream("D:\\JavaTest\\file.txt");
        FileInputStream fileIn = new FileInputStream("D:\\JavaTest\\file.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Solution sol = new Solution("D:\\JavaTest\\file.txt");
        sol.writeObject("Test String");
        out.writeObject(sol);
        Solution loadObj = (Solution) in.readObject();
        loadObj.writeObject("Test string 2");
    }

    public Solution(String fileName) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;

    }

    public void writeObject(String string) throws IOException
    {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.close();
    }
}
