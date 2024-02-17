package m.d.a.m.p.cc;

/**
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/
 */
public class Cc {
    public static void main(String[] args) {
        ArraysAndStrings.TwoPointersIsPalindrome.run();
        ArraysAndStrings.TwoPointersCheckForTarget.run();
    }

    static class ArraysAndStrings {
        static class TwoPointersIsPalindrome {
            static void run() {
                System.out.println("Is Palindrome. 'racecar' - " + isPalindrome("racecar"));
            }

            static boolean isPalindrome(String s) {
                int l = 0;
                int r = s.length() - 1;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        return false;
                    }
                    l++;
                    r--;
                }
                return true;
            }
        }

        static class TwoPointersCheckForTarget {
            static void run() {
                System.out.println("CheckForTarget. "
                        + checkForTarget(new int[]{1, 2, 4, 6, 8, 9, 14, 15}, 13));
            }

            static boolean checkForTarget(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        return true;
                    }
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
                return false;
            }
        }
    }
}
