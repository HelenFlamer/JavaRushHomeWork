package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private final String fileName;

    //напишите тут ваш код
    public Friend(String name)
    {

        this.fileName = name;
    }

    public Friend(String name, int age)
    {
        this.fileName = name + age;
    }

    public Friend(String name, int age, String gender)
    {

        this.fileName = name + age + gender;
    }
}