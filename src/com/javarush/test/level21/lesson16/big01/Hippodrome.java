package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Dmitry on 28.09.2016.
 */
public class Hippodrome
{
    public static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Gold", 3, 0);
        Horse horse2 = new Horse("Silver", 3, 0);
        Horse horse3 = new Horse("Bronze", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();

    }
    public void run() throws InterruptedException
    {
        for (int i = 1; i<101; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }
    public void print(){
        for (Horse horse : horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }
    public void move(){
        for (Horse horse : horses){
            horse.move();
        }

    }
    public Horse getWinner(){
        Horse winHorse = null;
        double winDistanse = -1;
        for (Horse horse : horses){
            if (horse.getDistance()>winDistanse){
                winDistanse = horse.getDistance();
                winHorse = horse;
            }
        }
        return winHorse;
    }
    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName()+"!");
    }
}
