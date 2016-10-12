package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2= new ArrayList<String>();
        list2.add("knbkmgb");
        list1.add("nbkjnbalk");
        list1.add("jknbelkf");
        list1.add("ljhbf");
        list2.add("ljfnbv");
        ArrayList<String>[] arrayOfString = new ArrayList[2];
        arrayOfString[0] =  list1;
        arrayOfString[1] = list2;

        return arrayOfString;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}