package m.d.a.m.p.lt.problems;

public class RansomNote {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().canConstruct("", ""));
    }

    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] count = new int[26];

            for (char letter : magazine.toCharArray()) count[letter - 'a']++;

            for (char letter : ransomNote.toCharArray()) {
                if (--count[letter - 'a'] < 0) return false;
            }
            return true;
        }
    }
}
