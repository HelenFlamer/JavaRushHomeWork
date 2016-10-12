package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        System.out.println(map);
        Set<String> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> catMap = new HashMap<>();
        Cat cat1 = new Cat("1");
        Cat cat2 = new Cat("2");
        Cat cat3 = new Cat("3");
        Cat cat4 = new Cat("4");
        Cat cat5 = new Cat("5");
        Cat cat6 = new Cat("6");
        Cat cat7 = new Cat("7");
        Cat cat8 = new Cat("8");
        Cat cat9 = new Cat("9");
        Cat cat10 = new Cat("10");
        catMap.put("11", cat1);
        catMap.put("2", cat2);
        catMap.put("3", cat3);
        catMap.put("4", cat4);
        catMap.put("5", cat5);
        catMap.put("6", cat6);
        catMap.put("7", cat7);
        catMap.put("8", cat8);
        catMap.put("9", cat9);
        catMap.put("10", cat10);
        return catMap;
    }

    public static Set<String> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<String> names = new HashSet<>();
        for (Map.Entry<String, Cat> entry : map.entrySet()){
            names.add(entry.getKey());
        }
        return names;
    }

    public static void printCatSet(Set<String> set)
    {
        for (String cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
