package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws TooShortStringException
    {
        System.out.print(getPartOfString("JavaRush - лучший способ обученvvfvия джава."));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();

        String[] st = string.split(" ");
        if (st.length < 5)
            throw new TooShortStringException();
        else
        return st[1] + " " + st[2] + " " + st[3] + " " + st[4];
    }

    public static class TooShortStringException extends Throwable
    {
    }
}
