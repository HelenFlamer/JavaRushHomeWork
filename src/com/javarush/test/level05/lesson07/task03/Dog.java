package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String color;
    private int hight;
    private String name;

    //напишите тут ваш код
    public void initialize(String name){
        this.name = name;
    }
    public void initialize(String name, int hight){
        this.name = name;
        this.hight = hight;
    }
    public void initialize(String name, int hight, String color){
        this.name = name;
        this.hight = hight;
        this.color = color;
    }

}
