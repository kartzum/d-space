package m.d.a.m.p.lt.problems;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
    }

    public static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null || s.length() <= 1) return true;
            HashMap<Character, Character> map = new HashMap<Character, Character>();
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                char b = t.charAt(i);
                if (map.containsKey(a)) {
                    if (map.get(a).equals(b))
                        continue;
                    else
                        return false;
                } else {
                    if (!map.containsValue(b))
                        map.put(a, b);
                    else return false;
                }
            }
            return true;
        }
    }
}
