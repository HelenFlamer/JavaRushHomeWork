package com.javarush.test.level22.lesson18.big01;

import java.util.ArrayList;

/**
 * Created by Dmitry on 02.10.2016.
 */
public class Field
{
    public int width;
    public int height;
    int[][] matrix;

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];

    }

    public Field(int[][] matrix)
    {
        this.matrix = matrix;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public void print()
    {
        int h = getHeight();
        int w = getWidth();
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (getValue(j, i) == 0)//не уверена, что последовательность переменных верная
                    System.out.print(".");
                else System.out.print("X");
            }
            System.out.println();
        }
    }


    public void removeFullLines()
    {
        ArrayList<int[]> lines = new ArrayList<>();

        //считаем сумму значений матрицы - проверяем есть ли нули
        for (int i = 0; i <height; i++)
        {
            int count = 0;
            for (int j = 0; j < width; j++)
            {
                count += matrix[i][j];
            }
            //если сумма не равна длине строки, значит строка не полностью заполнена
            if (count != width)
                lines.add(0,matrix[i]);
        }
        //дополняем лист пустымистроками взамен удаленных
        while (lines.size()<height)
        {
            lines.add(0,new int[width]);
        }
        //записываем лист обратно в матрицу
        matrix = lines.toArray(new int[height][width]);
    }



    public Integer getValue(int x, int y)
    {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];
            return null;
    }

    public void setValue(int x, int y, int value)
    {
    }

}
