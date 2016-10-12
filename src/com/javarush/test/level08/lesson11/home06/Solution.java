package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import javax.management.openmbean.TabularDataSupport;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> ch = new ArrayList<Human>();
        Human c1 = new Human("S", true, 20);
        ch.add(c1);
        Human c2 =new Human("C", true, 15 );
        ch.add(c2);
        Human c3 = new Human("W", false, 8);
        ch.add(c3);
        ArrayList<Human> f = new ArrayList<Human>();
        Human fa = new Human("V", true, 45, ch);
        f.add(fa);
        ArrayList<Human> m = new ArrayList<Human>();
        Human ma = new Human("J", false, 43, ch);
        m.add(ma);


        Human ded1 = new Human("A", true, 70, f );
        Human bab1 = new Human("AA", false, 69, f);
        Human ded2 = new Human("B", true, 66, m);
        Human bab2 = new Human("C", false, 63, m);

        System.out.println(ded1);
        System.out.println(bab1);
        System.out.println(ded2);
        System.out.println(bab2);
        System.out.println(fa);
        System.out.println(ma);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)

        {
            this.name=name;
            this.sex=sex;
            this.age=age;

            this.children = children;
        }
        public Human(String name, boolean sex, int age)

        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children = new ArrayList<>();

        }



        //напишите тут ваш код


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
