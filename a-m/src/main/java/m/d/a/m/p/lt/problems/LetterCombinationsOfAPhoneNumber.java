package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        new Solution().letterCombinations("23").forEach(System.out::println);
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> s = new ArrayList<>();

            if (digits == null || digits.length() == 0)
                return s;

            int len = digits.length();
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = digits.charAt(i) - '0';
            }

            String letters[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            Queue<String> que = new LinkedList<>();
            que.offer("");

            for (int i = 0; i < len; i++) {
                String word = letters[arr[i] - 2];
                int size = que.size();
                for (int j = 0; j < size; j++) {
                    String temp = que.poll();
                    for (char ch : word.toCharArray()) {
                        que.offer(temp + ch);
                    }
                }
            }
            return new ArrayList<>(que);
        }
    }
}
