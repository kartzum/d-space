package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class ReverseOnlyLetters {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().reverseOnlyLetters("ab-cd"));
    }

    static class Solution {
        public String reverseOnlyLetters(String S) {
            Stack<Character> letters = new Stack<>();
            for (char c: S.toCharArray())
                if (Character.isLetter(c))
                    letters.push(c);

            StringBuilder ans = new StringBuilder();
            for (char c: S.toCharArray()) {
                if (Character.isLetter(c))
                    ans.append(letters.pop());
                else
                    ans.append(c);
            }

            return ans.toString();
        }
    }

}
