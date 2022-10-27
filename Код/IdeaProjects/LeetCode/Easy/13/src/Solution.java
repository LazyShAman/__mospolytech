import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int n = 0;

        if (s.contains("IV")) n -= 2;

        if (s.contains("IX")) n -= 2;

        if (s.contains("XL")) n -= 20;

        if (s.contains("XC")) n -= 20;

        if (s.contains("CD")) n -= 200;

        if (s.contains("CM")) n -= 200;

        Map<Character, Integer> rti = new HashMap<>();
        rti.put('I', 1);
        rti.put('V', 5);
        rti.put('X', 10);
        rti.put('L', 50);
        rti.put('C', 100);
        rti.put('D', 500);
        rti.put('M', 1000);

        for (char c : s.toCharArray()) {
            n += rti.get(c);
        }

        return n;
    }
}