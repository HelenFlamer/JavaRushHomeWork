package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args){
        removeTheFirstNameDuplicates(createMap());
    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "masa");
        map.put("2", "dasa");
        map.put("3", "misa");
        map.put("4", "kata");
        map.put("5", "masa");
        map.put("6", "misa");
        map.put("7", "lena");
        map.put("8", "masa");
        map.put("9", "ola");
        map.put("10", "dasa");

        return (HashMap<String, String>) map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        Map<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            String value = pair.getValue();
            int count = 0;
            for (Map.Entry<String, String> el : copy.entrySet())
            {
                if (el.getValue().equals(value))
                    count++;
                if (count > 1){
                    removeItemFromMapByValue(map, value);

                }

            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {

            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
