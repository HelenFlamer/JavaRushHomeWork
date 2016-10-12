package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

import java.lang.ref.SoftReference;

public class Solution
{


    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man = new Man("Vlad", 15, "Hell street");
        Man man1 = new Man("Egor", 16, " Hole street");
        Woman woman = new Woman("Lena", 17, "Lenin street");
        Woman woman1 = new Woman("Masha", 26, "Stalin square ");

        System.out.println(man);
        System.out.println(man1);
        System.out.println(woman);
        System.out.println(woman1);


    }


    public static class Man
    {
        String name;
        int age;
        String address;


        public Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString()
        {
            return name.toString() + " " + age + " " + address.toString();
        }
    }

    public static class Woman
    {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString()
        {
            return name.toString() + " " + age + " " + address.toString();
        }
    }
}
