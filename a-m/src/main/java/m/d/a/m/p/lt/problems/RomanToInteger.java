package m.d.a.m.p.lt.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().romanToInt("I"));
    }

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int res = 0;
            for (Character c : s.toCharArray()) {
                res += map.get(c);
            }

            if (s.contains("IV") || s.contains("IX")) {
                res -= 2;
            }
            if (s.contains("XL") || s.contains("XC")) {
                res -= 20;
            }
            if (s.contains("CM") || s.contains("CD")) {
                res -= 200;
            }
            return res;
        }
    }
}
