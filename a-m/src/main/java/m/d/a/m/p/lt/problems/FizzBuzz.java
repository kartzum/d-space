package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().fizzBuzz(15));
    }

    static class Solution {
        public List<String> fizzBuzz(int n) {
            // ans list
            List<String> ans = new ArrayList<>();

            for (int num = 1; num <= n; num++) {

                boolean divisibleBy3 = (num % 3 == 0);
                boolean divisibleBy5 = (num % 5 == 0);

                String numAnsStr = "";

                if (divisibleBy3) {
                    // Divides by 3, add Fizz
                    numAnsStr += "Fizz";
                }

                if (divisibleBy5) {
                    // Divides by 5, add Buzz
                    numAnsStr += "Buzz";
                }

                if (numAnsStr.equals("")) {
                    // Not divisible by 3 or 5, add the number
                    numAnsStr += Integer.toString(num);
                }

                // Append the current answer str to the ans list
                ans.add(numAnsStr);
            }

            return ans;
        }
    }
}
