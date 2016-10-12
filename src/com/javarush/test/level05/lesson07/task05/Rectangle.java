package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int left;
    private int top;
    private int widht;
    private int height;
    private Rectangle rectangle;

    //напишите тут ваш код
    public void initialize(int left, int top, int widht, int height){
        this.left = left;
        this.top = top;
        this.widht = widht;
        this.height = height;
    }
    public void initialize(int left, int top,  int height){
        this.left = left;
        this.top = top;
        this.widht = 0;
        this.height = height;
    }
    public void initialize(int left, int top){
        this.left = left;
        this.top = top;
        this.widht = 0;
        this.height = 0;
    }
   public void initialize(Rectangle rectangle){
       this.rectangle = rectangle;
   }
}
