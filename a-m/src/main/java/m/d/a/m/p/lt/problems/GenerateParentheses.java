package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    static void test1() {
        List<String> r = new Solution1().generateParenthesis(3);
        for (String s : r) {
            System.out.println(s);
        }
    }

    static void test2() {
        List<String> r = new Solution2().generateParenthesis(3);
        for (String s : r) {
            System.out.println(s);
        }
    }

    static class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList<>();
            generateAll(new char[2 * n], 0, combinations);
            return combinations;
        }

        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current))
                    result.add(new String(current));
            } else {
                current[pos] = '(';
                // String t = new String(current);
                // System.out.println(t);
                generateAll(current, pos + 1, result);
                current[pos] = ')';
                // String t1 = new String(current);
                // System.out.println(t1);
                generateAll(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return (balance == 0);
        }
    }

    static class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, String cur, int open, int close, int max) {
            // System.out.println(cur);
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }

            if (open < max)
                backtrack(ans, cur + "(", open + 1, close, max);
            if (close < open)
                backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}
