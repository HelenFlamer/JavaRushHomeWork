package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Dmitry on 28.09.2016.
 */
public class Horse
{
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public void move(){
        distance+=Math.random()*speed;
    }
    public void print(){
        String points = "";
        int count = (int) Math.round(distance);
        for (int i = 0; i<count;i++){
            points+=".";
        }
        System.out.println(points+this.getName());
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }
}
