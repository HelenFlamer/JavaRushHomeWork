package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int [] num = new int [10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i<10;i++){
            num[i] = Integer.parseInt(reader.readLine());
        }
        int [] tmp = new int[1];
        for (int i = 0; i<5;i++)
        {
            tmp[0] = num[i];
            num[i] = num[9-i];
            num[9-i] = tmp[0];
        }

        for (int g  = 0;g<10;g++){
            System.out.println(num[g]);
        }

    }
}
