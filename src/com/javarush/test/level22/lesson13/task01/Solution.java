package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer =
                new StringTokenizer(query,delimiter);
        List<String> list = new ArrayList<>();
        int i = 0;
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String [] tokens = new String[list.size()];
        for (String s : list){
            tokens[i] = s;
            i++;
        }

        return tokens;
    }
}
