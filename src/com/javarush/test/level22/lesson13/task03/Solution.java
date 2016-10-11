package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр !!!!!!!!!!!!!!!!
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр??????????????
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв!!!!!!!!!!!!!!!!!!
7) номер заканчивается на цифру!!!!!!!!!!!


Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution
{


    public static boolean checkTelNumber(String telNumber)
    {

        boolean flag = false;

        int countMinus = 0;
        int countSkob1 = 0, countScob2 = 0;
        int pos1 = -1, pos2 = -1;
        int sc1 = -1, sc2 = -1;
        for (int i = 0; i < telNumber.length(); i++)
        {
            if (telNumber.charAt(i) == '-')
            {
                countMinus++;
                if (countMinus == 1)
                    pos1 = i;
                if (countMinus == 2)
                    pos2 = i;
            }
            if (telNumber.charAt(i) == '(')
            {
                countSkob1++;
                if (countSkob1 == 1)
                    sc1 = i;
            }
            if (telNumber.charAt(i) == ')')
            {
                countScob2++;
                if (countScob2 == 1)
                    sc2 = i;
            }
        }
        if (countSkob1 > 1 || countScob2 > 1 || (countScob2 == 1 && countSkob1 == 1 && (sc2 < sc1 || sc2 - sc1 != 4)))
            return false;
        if (countScob2 == 1 && countMinus > 0 && sc2 > pos1)
            return false;
        if (countMinus > 2 || (pos1 > 0 && pos2 > 0 && (pos2 - pos1) < 2))
            return false;
        else if (telNumber.matches("\\w"))
            return false;
        else if (telNumber.matches(".*\\D$"))
            return false;
        else if (telNumber.matches("^[\\+]{1}.*"))
        {
            int count = 0;
            for (int i = 0; i < telNumber.length() - 1; i++)
            {
                if (telNumber.substring(i, i + 1).matches("[0-9]"))
                    count++;
            }
            if (telNumber.substring(telNumber.length() - 1).matches("[0-9]"))
                count++;
            if (count == 12)
                flag = true;
        } else if (telNumber.matches("^([(]|[0-9]).*"))
        {
            int count = 0;
            for (int i = 0; i < telNumber.length() - 1; i++)
            {
                if (telNumber.substring(i, i + 1).matches("[0-9]"))
                    count++;
            }
            if (telNumber.substring(telNumber.length() - 1).matches("[0-9]"))
                count++;
            if (count == 10)
                flag = true;
        }
        return flag;
    }
}
