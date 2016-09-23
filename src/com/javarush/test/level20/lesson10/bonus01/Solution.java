package com.javarush.test.level20.lesson10.bonus01;


import java.util.ArrayList;
import java.util.Arrays;

/* Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static int[] getNumbers(int N)
    {
        ArrayList<Long> combinations = new ArrayList<>();
        ArrayList<Long> tmpList = new ArrayList<>();
        int M = (int) Math.log10(N - 1) + 1;

        for (int n = 1; n <= M; n++)
        {
            for (int i = 0; i < 10; i++)
            {
                if (i == 0 && n == 1)
                {
                } else
                {
                    if (combinations.size() == 0)
                    {
                        tmpList.add((long) i);
                    } else for (Long d : combinations)
                    {
                        if ((i <= (d % 10)))
                        {
                            long b = 10 * d + i;
                            if (b >= Math.pow(10, n - 1))
                            {
                                tmpList.add(b);
                            }
                        }
                    }
                }
            }
            for (Long s : tmpList)
            {
                {
                    combinations.add(s);
                }
            }
        }

        combinations.clear();
        ArrayList<Integer> finalList= new ArrayList<>();
        for (Long number : tmpList)
        {
            int power = (int) (Math.log10(number) + 1);// в какую степень возводить цифры
            int[] chars = new int[power];
            int summa = 0;
            // нашли все цифры числа,добавили к сумме
            for (int i = 0; i < power; i++)
            {
                chars[i] = (int) ((number / (int) Math.pow(10, i)) % 10);
                summa += Math.pow(chars[i], power);
            }
            if (summa < N)
            {
                String sum = String.valueOf(summa);
                for (int i = 0; i < power; i++)
                {
                    if (sum.length() > 0 && sum.contains(String.valueOf(chars[i])))
                    {
                        sum = sum.replaceFirst(String.valueOf(chars[i]), "");
                    } else sum = "NO";
                }
                if (sum.length() == 0)
                {
                    finalList.add(summa);
                }
            }

        }
        tmpList.clear();
        int index = 0;
        int [] result = new int[finalList.size()];
        for (Integer s : finalList)
        {
            result[index] = s;
            index++;
        }

        Arrays.sort(result);
        for (Integer a : result)
        {
            System.out.println(a);
        }
        return result;
    }


}
