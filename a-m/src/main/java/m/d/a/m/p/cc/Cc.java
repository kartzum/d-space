package m.d.a.m.p.cc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/
 */
public class Cc {
    public static void main(String[] args) {
        // ArraysAndStrings.TwoPointersIsPalindrome.run();
        // ArraysAndStrings.TwoPointersCheckForTarget.run();
        // ArraysAndStrings.TwoPointersCombine.run();
        // ArraysAndStrings.SlidingWindowFindLength.run();
        // ArraysAndStrings.SlidingWindowFindLengthZero.run();
        ArraysAndStrings.SlidingWindowNumSubarrayProductLessThanK.run();
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

        static class TwoPointersCombine {
            static void run() {
                System.out.println("Combine.");
                combine(new int[]{1, 4, 7, 20}, new int[]{3, 5, 6}).forEach((i) -> System.out.print(i + ","));
                System.out.println();
            }

            static List<Integer> combine(int[] arr1, int[] arr2) {
                List<Integer> ans = new ArrayList<>();
                int i = 0;
                int j = 0;
                while (i < arr1.length && j < arr2.length) {
                    if (arr1[i] < arr2[j]) {
                        ans.add(arr1[i]);
                        i++;
                    } else {
                        ans.add(arr2[j]);
                        j++;
                    }
                }
                while (i < arr1.length) {
                    ans.add(arr1[i]);
                    i++;
                }
                while (j < arr2.length) {
                    ans.add(arr1[j]);
                    j++;
                }
                return ans;
            }
        }

        static class SlidingWindowFindLength {
            static void run() {
                System.out.println("findLength. " + findLength(new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5}, 8));
            }

            static int findLength(int[] nums, int k) {
                int left = 0;
                int curr = 0;
                int ans = 0;

                for (int right = 0; right < nums.length; right++) {
                    curr += nums[right];
                    while (curr > k) {
                        curr -= nums[left];
                        left++;
                    }

                    ans = Math.max(ans, right - left + 1);
                }

                return ans;
            }
        }

        static class SlidingWindowFindLengthZero {
            static void run() {
                System.out.println("findLength. " + findLength("1101100111"));
            }

            static int findLength(String s) {
                int left = 0;
                int curr = 0;
                int ans = 0;
                for (int right = 0; right < s.length(); right++) {
                    if (s.charAt(right) == '0') {
                        curr++;
                    }
                    while (curr > 1) {
                        if (s.charAt(left) == '0') {
                            curr--;
                        }
                        left++;
                    }

                    ans = Math.max(ans, right - left + 1);
                }
                return ans;
            }
        }

        static class SlidingWindowNumSubarrayProductLessThanK {
            static void run() {
                System.out.println("K. " + numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
            }

            static int numSubarrayProductLessThanK(int[] nums, int k) {
                int left = 0;
                int curr = 1;
                int ans = 0;
                for (int right = 0; right < nums.length; right++) {
                    curr *= nums[right];
                    while (curr >= k) {
                        curr /= nums[left];
                        left++;
                    }
                    ans += right - left + 1;
                }
                return ans;
            }
        }
    }
}
