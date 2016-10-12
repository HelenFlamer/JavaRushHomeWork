package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    private int centerX;
    private int centerY;
    private int redius;
    private int widht;
    private String color;

    //напишите тут ваш код
    public void initialize(int centerX, int centerY, int radius)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.redius = radius;
    }
    public void initialize(int centerX, int centerY, int radius, int width){
        this.centerX = centerX;
        this.centerY = centerY;
        this.redius = radius;
        this.widht = width;
    }
    public void initialize(int centerX, int centerY, int radius, int width, String color){
        this.centerX = centerX;
        this.centerY = centerY;
        this.redius = radius;
        this.widht = width;
        this.color = color;
    }
}
