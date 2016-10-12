package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human dad1 = new Human("Kolya", true, 57, null, null);
        Human bab1 = new Human("olga", false, 50, null, null);
        Human dad2 = new Human("Oleg", true, 50, null, null);
        Human bab2 = new Human("Larisa", false, 47, null, null);
        Human father = new Human("Dima", true, 28, dad1, bab1);
        Human mother = new Human("Lena", false, 24, dad2, bab2);
        Human child1 = new Human("Sasha", true, 5, father, mother);
        Human child2 = new Human("Pasha", true, 3, father, mother);
        Human child3 = new Human("Masha", false, 1, father, mother);

        System.out.println(dad1);
        System.out.println(bab1);
        System.out.println(dad2);
        System.out.println(bab2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);



    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        //напишите тут ваш код
        public Human(String name,boolean sex, int age,Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
