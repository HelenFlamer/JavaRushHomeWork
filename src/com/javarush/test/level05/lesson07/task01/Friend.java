package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String fileName = null;
    //напишите тут ваш код

    public void initialize(String name)
    {
        this.fileName = name;
    }

    public void initialize(String name, int age)
    {
        this.fileName = name + age;
    }

    public void initialize(String name, int age, String gender)
    {

        this.fileName = name + age + gender;
    }
}
