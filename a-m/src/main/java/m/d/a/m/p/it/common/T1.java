package m.d.a.m.p.it.common;

public class T1 {
    public static void main(String[] args) {
        // maxConTest();
        // areAnagramTest();
        printParenthesisTest();
    }

    // Maximum consecutive one’s (or zeros) in a binary array.
    // https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/

    static void maxConTest() {
        System.out.println("2 = " + getMaxLength(new int[]{1, 1, 0, 1, 1, 0}));
        System.out.println("3 = " + getMaxLength(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println("3 = " + getMaxLength(new int[]{1, 1, 1}));
        System.out.println("0 = " + getMaxLength(new int[]{0, 0, 0}));
        System.out.println("0 = " + getMaxLength(new int[]{}));
    }

    static int getMaxLength(int arr[]) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count += 1;
                result = Math.max(result, count);
            }
        }
        return result;
    }

    // Check whether two strings are anagram of each other.
    // https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
    // https://www.baeldung.com/java-strings-anagrams

    static void areAnagramTest() {
        System.out.println("true = " + areAnagram(("abc").toCharArray(), ("cba").toCharArray()));
        System.out.println("false = " + areAnagram(("sleep").toCharArray(), ("slep").toCharArray()));
    }

    static boolean areAnagram(char str1[], char str2[]) {
        if (str1.length != str2.length) {
            return false;
        }
        int m = 256;
        int[] count = new int[m];
        for (int i = 0; i < str1.length; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }
        for (int i = 0; i < str1.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // Print all combinations of balanced parentheses.
    // https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/

    static void printParenthesisTest() {
        int n = 2;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }

    static void _printParenthesis(char str[], int pos, int n, int open, int close) {
        if (close == n) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
        } else {
            if (open > close) {
                str[pos] = ')';
                _printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '(';
                _printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }

    static void printParenthesis(char str[], int n) {
        if (n > 0)
            _printParenthesis(str, 0, n, 0, 0);
    }
}
