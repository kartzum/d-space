package m.d.a.m.p.lt.problems;

public class ReverseWordsInAStringIII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }

    static class Solution {
        public String reverseWords(String s) {
            String words[] = s.split(" ");
            StringBuilder res = new StringBuilder();
            for (String word : words)
                res.append(new StringBuffer(word).reverse().toString() + " ");
            return res.toString().trim();
        }
    }
}
