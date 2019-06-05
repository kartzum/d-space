package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        String j = "aA";
        String s = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(j, s));
    }

    static class Solution {
        public int numJewelsInStones(String J, String S) {
            char[] jA = J.toCharArray();
            Set<Character> jSet = new HashSet<>();
            for (char c1 : jA) {
                jSet.add(c1);
            }
            int r = 0;
            char[] sA = S.toCharArray();
            for (char c : sA) {
                if (jSet.contains(c)) {
                    r += 1;
                }
            }
            return r;
        }
    }
}
