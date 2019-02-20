package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String v = tokens[i];
                if (v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/")) {
                    int v1 = stack.pop();
                    int v2 = stack.pop();
                    switch (v) {
                        case "+":
                            stack.push(v2 + v1);
                            break;
                        case "-":
                            stack.push(v2 - v1);
                            break;
                        case "*":
                            stack.push(v2 * v1);
                            break;
                        case "/":
                            stack.push(v2 / v1);
                            break;
                    }
                } else {
                    stack.push(Integer.parseInt(v));
                }
            }
            return stack.peek();
        }
    }
}
