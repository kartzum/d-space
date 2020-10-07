package m.d.a.m.p.t.t1;

import java.util.Arrays;

public class T10 {
    public static void main(String[] args) {
        // removeDuplicatesTest();
        // removeSpacesTest();
        // removeSpaces2Test();
        // rotateArrayTest();
        maxDepthTest();
    }

    // 26. Remove Duplicates from Sorted Array.
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    static void removeDuplicatesTest() {
        int[] nums = new int[]{1, 2, 3, 4, 4, 4, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // Remove extra spaces from a string.
    // https://www.geeksforgeeks.org/remove-extra-spaces-string/

    static void removeSpacesTest() {
        char[] str = "   123  45   6   7".toCharArray();
        int s = removeSpaces(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(str[i]);
        }
        System.out.println("'" + sb.toString() + "'");
    }

    static void removeSpaces2Test() {
        char[] str = "  123  45   6  7".toCharArray();
        int s = removeSpaces2(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(str[i]);
        }
        System.out.println("'" + sb.toString() + "'");
    }

    static int removeSpaces(char[] str) {
        int i = 0;
        int j = -1;
        int n = str.length;
        boolean spaceFound = false;
        while (++j < n && str[j] == ' ') ;
        while (j < n) {
            // if current characters is non-space
            if (str[j] != ' ') {
                // remove preceding spaces before dot,
                // comma & question mark
                if ((str[j] == '.' || str[j] == ',' ||
                        str[j] == '?') && i - 1 >= 0 &&
                        str[i - 1] == ' ')
                    str[i - 1] = str[j++];

                else
                    // copy current character at index i
                    // and increment both i and j
                    str[i++] = str[j++];

                // set space flag to false when any
                // non-space character is found
                spaceFound = false;
            }
            // if current character is a space
            else if (str[j++] == ' ') {
                // If space is encountered for the first
                // time after a word, put one space in the
                // output and set space flag to true
                if (!spaceFound) {
                    str[i++] = ' ';
                    spaceFound = true;
                }
            }
        }
        return i;
    }

    static int removeSpaces2(char[] str) {
        int i = 0;
        for (int j = 1; j < str.length; j++) {
            if (str[i] != str[j]) {
                i++;
                str[i] = str[j];
            }
        }
        return i + 1;
    }

    static void rotateArrayTest() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    static void rotateArray(int[] nums, int k) {
        rotateArrayReverse(nums, 0, nums.length - 1);
        rotateArrayReverse(nums, 0, k - 1);
        rotateArrayReverse(nums, k, nums.length - 1);
    }

    static void rotateArrayReverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 104. Maximum Depth of Binary Tree.
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/

    static void maxDepthTest() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;
        System.out.println(maxDepth(n3));
    }

    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // Structures.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
}
