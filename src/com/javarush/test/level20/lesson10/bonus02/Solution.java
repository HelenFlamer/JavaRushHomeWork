package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a)
    {
        int count = 0;
        boolean start = false;
        boolean end = false;
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;

        for (int y = 0; y < a.length; y++)
        {
            for (int x = 0; x < a[y].length; x++)
            {

                if (a[y][x] == 1)
                {
                    a[y][x] = 3;
                    start = true;
                    startX = 0;
                    startY = 0;
                    for (int i = startX + 1; i < a[y].length; i++)
                    {
                        while (true)
                        {
                            if (a[y][i] == 1)
                            {
                                a[y][i] = 0;
                                break;

                            } else if (a[y][i] == 0)
                            {
                                endX = i;
                            }
                        }
                        if (endX == i)
                            break;

                    }
                    for (int i = startY + 1; i < a.length; i++)
                    {
                        if (a[i][x] == 1)
                        {
                            a[i][x] = 0;

                        } else if (a[i][x] == 0)
                        {
                            endY = i;
                            end = true;
                        }
                        if (endY == i)
                            break;
                    }
                    for (int c = startX + 1; c < endX; c++)
                    {
                        for (int b = startY + 1; b < endY; b++)
                        {
                            a[c][b] = 0;
                        }
                    }
                    if (start && end)
                    {
                        count++;
                        start = false;
                        end = false;
                        break;
                    }
                }

            }
        }

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (a[i][j] == 3) count++;
            }
        }

        return count;
    }
}
