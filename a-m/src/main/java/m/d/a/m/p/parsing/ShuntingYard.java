package m.d.a.m.p.parsing;

import java.util.*;

public class ShuntingYard {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        execute("1 + 2");
        execute("3 + 4 * 2 / ( 1 - 5 )");
        execute("( 1 + 2 ) * 4 + 3");
        execute("( ( 15 / ( 7 - ( 1 + 1 ) ) ) * 3 ) - ( 2 + ( 1 + 1 ) )");
    }

    private static void execute(String value) {
        System.out.print(value + ": ");
        List<String> r1 = new Solution().parse(value);
        for (String t : r1) {
            System.out.print(t);
            System.out.print(" ");
        }
        System.out.println();
    }

    static class Solution {
        Map<String, Integer> operatorsPriorities = new HashMap<>();

        Solution() {
            operatorsPriorities.put("+", 0);
            operatorsPriorities.put("-", 0);
            operatorsPriorities.put("*", 1);
            operatorsPriorities.put("/", 1);
        }

        List<String> parse(String value) {
            boolean logging = false;
            if (value == null || value.length() == 0) {
                return new ArrayList<>();
            }
            List<String> out = new ArrayList<>();
            Stack<String> operators = new Stack<>();
            String[] tokens = value.split(" ");
            if (logging) {
                System.out.println(Arrays.toString(tokens));
            }
            for (String token : tokens) {
                if (isNumber(token)) {
                    out.add(token);
                } else if (isOperator(token)) {
                    String operatorCurrent = token;
                    while (!operators.isEmpty() && isOperator(operators.peek()) &&
                            operatorsPriorities.get(operatorCurrent)
                                    < operatorsPriorities.get(operators.peek())) {
                        out.add(operators.pop());
                    }
                    operators.push(operatorCurrent);
                } else if (isOpenBrace(token)) {
                    operators.push(token);
                } else if (isCloseBrace(token)) {
                    while (!operators.isEmpty()) {
                        String operatorLocal = operators.peek();
                        if (!isOpenBrace(operatorLocal)) {
                            out.add(operators.pop());
                        } else {
                            break;
                        }
                    }
                    if (!operators.isEmpty()) {
                        operators.pop();
                    }
                }
            }
            while (!operators.isEmpty()) {
                out.add(operators.pop());
            }
            return out;
        }

        boolean isNumber(String value) {
            for (char c : value.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }

        boolean isOperator(String value) {
            return value.equals("+") || value.equals("-")
                    || value.equals("*") || value.equals("/");
        }

        boolean isOpenBrace(String value) {
            return value.contains("(");
        }

        boolean isCloseBrace(String value) {
            return value.contains(")");
        }
    }
}
