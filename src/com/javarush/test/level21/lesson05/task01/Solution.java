package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution
{
    private final String first, last;

    public Solution(String first, String last)
    {
        this.first = first;
        this.last = last;
    }
    @Override
    public int hashCode()
    {
        if (first == null || last == null) return 0;
        int result;
        result = 31 * first.hashCode() + last.hashCode();
        return result;

    }

    @Override
    public boolean equals(Object n)
    {
        if (this == n) return true;
        if (n == null) return false;
        if (getClass() != n.getClass()) return false;
        Solution other = (Solution) n;
        if (first != other.first) return false;
        if (last != other.last) return false;
        return true;
    }

    public static void main(String[] args)
    {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
