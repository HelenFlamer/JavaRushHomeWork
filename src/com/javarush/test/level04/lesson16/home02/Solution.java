package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());

        if ((a>=b)&&(b>=c))
            System.out.println(b);
        if ((a>=b)&&(c>b)){
            if (a>=c)
            System.out.println(c);
        else System.out.println(a); }
        if (b>a){
            if (c>=b)
                System.out.println(b);
            else {//b>c
                if (a>=c)
                    System.out.println(a);
                else //c>a
                    System.out.println(c);
            }
        }
    }
}
