package com.javarush.test.level20.lesson04.task05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static class Object implements Serializable{
        public String string1;
        public String string2;

        public void writeExternal(ObjectOutputStream objectOutputStream) throws IOException
        {
            objectOutputStream.writeObject(string1);
            objectOutputStream.writeObject(string2);
        }
        public void readExternal(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException
        {
            int c = countStrings;
            string1 = (String) objectInputStream.readObject();
            string2 = (String) objectInputStream.readObject();
            countStrings = c;
        }
    }

    public static int countStrings;

    public static class String implements Serializable{
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
