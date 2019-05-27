package m.d.a.m.p.lt.problems;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (counts.containsKey(s.charAt(i))) {
                    counts.put(s.charAt(i), counts.get(s.charAt(i)) + 1);
                } else {
                    counts.put(s.charAt(i), 1);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int k = counts.get(c);
                if (k == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
