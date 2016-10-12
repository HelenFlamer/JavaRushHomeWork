package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код
        Cat tomCat = new Cat ("jfdbv", 6, 15);
        Dog dog = new Dog("Шарик", 5, 14);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
    public static class Dog
    {
        String name;
        int age;
        int height;

        public Dog(String name, int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
        }
    }

    public static class Cat
    {
        String address;
        int age;
        int tail;

        public Cat(String address, int age, int tail){
            this.address = address;
            this.age = age;
            this.tail = tail;
        }
    }
}
