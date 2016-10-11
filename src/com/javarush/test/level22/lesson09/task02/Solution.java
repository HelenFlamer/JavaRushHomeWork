package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution
{



    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (Map.Entry<String, String> map : params.entrySet())
        {
            String key = map.getKey();
            String value = map.getValue();
            if (value != null)
            {
                if (count == 0)
                {
                    sb.append(key + " = ");
                    count++;
                } else
                {
                    sb.append(" and " + key + " = ");
                }
                sb.append("\'" + value + "\'");
            }
        }
        return sb;
    }
}
