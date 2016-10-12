package com.javarush.test.level08.lesson06.task05;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Четыре метода
Реализовать 4 метода. Они должны возвращать список, который лучше всего подходит для выполнения данных операций (быстрее всего справится с большим количеством операций). Ничего измерять не нужно.
*/

public class Solution
{
    public static void main(String[] arg)
    {
        getListForGet();
        getListForSet();
        getListForAddOrInsert();
        getListForRemove();
    }

    public static List getListForGet()
    {
        //напишите тут ваш код
        ArrayList arrayList=new ArrayList();
        for(int i=0; i<arrayList.size(); i++){
            arrayList.get(i);
        }
        return arrayList;
        /*List<Object> list1 = new ArrayList<>();
        Date startDate1 = new Date();
        for (int i=0;i<10000;i++)
        {
            list1.get(i);
        }
        Date endDate1 = new Date();
        long time1 = endDate1.getTime() - startDate1.getTime();


        List<Object> list2 = new LinkedList<>();
        Date startDate2 = new Date();
        for (int i=0;i<10000;i++)
        {
            list2.get(i);
        }
        Date endDate2 = new Date();
        long time2 = endDate2.getTime() - startDate2.getTime();

        if (time1<=time2)
            return list1;
        else
            return list2;
*/

    }

    public static List getListForSet()
    {
        //напишите тут ваш код
        ArrayList arrayList=new ArrayList();
        for (int i=0; i<arrayList.size(); i++)
        {
            arrayList.set(i, arrayList);
        }
        return arrayList;       /* List<Object> list1 = new ArrayList<>();
        Date startDate1 = new Date();
        for (int i=0;i<10000;i++)
        {
            list1.set(i, "");
        }
        Date endDate1 = new Date();
        long time1 = endDate1.getTime() - startDate1.getTime();


        List<Object> list2 = new LinkedList<>();
        Date startDate2 = new Date();
        for (int i=0;i<10000;i++)
        {
            list2.set(i, "");
        }
        Date endDate2 = new Date();
        long time2 = endDate2.getTime() - startDate2.getTime();

        if (time1<=time2)
            return list1;
        else
            return list2;*/


    }

    public static List getListForAddOrInsert()
    {
        //напишите тут ваш код
        LinkedList list = new LinkedList();
        for (int i=0; i<list.size(); i++)
        {
            list.add(list);
        }
        return list;
        /* List<Object> list1 = new ArrayList<>();
        Date startDate1 = new Date();
        for (int i=0;i<10000;i++)
        {
            list1.add(i, "");
        }
        Date endDate1 = new Date();
        long time1 = endDate1.getTime() - startDate1.getTime();


        List<Object> list2 = new LinkedList<>();
        Date startDate2 = new Date();
        for (int i=0;i<10000;i++)
        {
            list2.add(i, "");
        }
        Date endDate2 = new Date();
        long time2 = endDate2.getTime() - startDate2.getTime();

        if (time1<=time2)
            return list1;
        else
            return list2;
*/  }

    public static List getListForRemove()
    {
        //напишите тут ваш код
        /*List<Object> list1 = new ArrayList<>();
        Date startDate1 = new Date();
        for (int i=0;i<10000;i++)
        {
            list1.remove(i);
        }
        Date endDate1 = new Date();
        long time1 = endDate1.getTime() - startDate1.getTime();


        List<Object> list2 = new LinkedList<>();
        Date startDate2 = new Date();
        for (int i=0;i<10000;i++)
        {
            list2.remove(i);
        }
        Date endDate2 = new Date();
        long time2 = endDate2.getTime() - startDate2.getTime();

        if (time1<=time2)
            return list1;
        else
            return list2;*/
        LinkedList list = new LinkedList();
        for (int i=0; i<list.size(); i++)
        {
            list.remove();
        }
        return list;
    }
}
