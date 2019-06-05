package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("au"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcb"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            int r = Integer.MIN_VALUE;
            Set<Character> set = new HashSet<>();
            for (int i = 1; i < s.length(); i++) {
                set.add(s.charAt(i - 1));
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (set.contains(c)) {
                        if (set.size() > r) {
                            r = set.size();
                        }
                        set.clear();
                        break;
                    } else {
                        set.add(c);
                    }
                }
            }
            if (set.size() > 0 && set.size() > r) {
                return set.size();
            }
            return r;
        }
    }
}
