package m.d.a.m.p.t.t1;

import java.util.Arrays;

public class T10 {
    public static void main(String[] args) {
        // removeDuplicatesTest();
        // removeSpacesTest();
        removeSpaces2Test();
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
}
