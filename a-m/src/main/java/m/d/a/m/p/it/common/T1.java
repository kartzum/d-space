package m.d.a.m.p.it.common;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        // maxConTest();
        // areAnagramTest();
        // printParenthesisTest();
        // reverseListTest();
        // longestOnesTest();
        // moveZeroesTest();
        twoSumTest();
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
    // https://leetcode.com/problems/generate-parentheses/

    static void printParenthesisTest() {
        List<String> r = generateParenthesis(3);
        System.out.println(Arrays.toString(r.toArray()));
    }

    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    // Reverse Linked List.
    // https://leetcode.com/problems/reverse-linked-list/

    static void reverseListTest() {
        ListNode n0 = new ListNode(0, null);
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, null);
        n0.next = n1;
        n1.next = n2;
        ListNode r = reverseList(n0);
        print(r);
    }

    static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    // Max Consecutive Ones III.
    // https://leetcode.com/problems/max-consecutive-ones-iii/

    static void longestOnesTest() {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(a, 2));
    }

    static int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
        }
        return right - left;
    }

    // Move Zeroes.
    // https://leetcode.com/problems/move-zeroes/

    static void moveZeroesTest() {
        int[] nums = new int[]{1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }

    // Two Sum.
    // https://leetcode.com/problems/two-sum/

    static void twoSumTest() {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] r = twoSum(nums, 9);
        System.out.println(Arrays.toString(r));
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Three and others.

    static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
