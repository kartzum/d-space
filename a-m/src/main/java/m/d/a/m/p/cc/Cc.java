package m.d.a.m.p.cc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        // ArraysAndStrings.SlidingWindowNumSubarrayProductLessThanK.run();
        // ArraysAndStrings.PrefixSumAnswerQueries.run();
        // Backtracking.AllPathsFromSourceToTarget.run();
        Backtracking.LetterCombinationsOfAPhoneNumber.run();
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

        static class PrefixSumAnswerQueries {
            static void run() {
                System.out.println("answerQueries");
                boolean[] ans = answerQueries(
                        new int[]{1, 6, 3, 2, 7, 2},
                        new int[][]{{0, 3}},
                        13
                );
                for (boolean an : ans) {
                    System.out.print(an + ",");
                }
                System.out.println();
            }

            static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
                int[] prefix = new int[nums.length];
                prefix[0] = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    prefix[i] = prefix[i - 1] + nums[i];
                }

                boolean[] ans = new boolean[queries.length];
                for (int i = 0; i < queries.length; i++) {
                    int x = queries[i][0], y = queries[i][1];
                    int curr = prefix[y] - prefix[x] + nums[x];
                    ans[i] = curr < limit;
                }

                return ans;
            }
        }
    }

    static class Backtracking {
        static class AllPathsFromSourceToTarget {
            static void run() {
                System.out.println("AllPathsFromSourceToTarget.");
                List<List<Integer>> r = new Solution().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
                r.forEach((i) -> {
                    i.forEach((j) -> System.out.print(j + ","));
                    System.out.println();
                });
                System.out.println();
            }

            static class Solution {
                private int target;
                private int[][] graph;
                private List<List<Integer>> results;

                public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
                    this.target = graph.length - 1;
                    this.graph = graph;
                    this.results = new ArrayList<>();
                    LinkedList<Integer> path = new LinkedList<>();
                    path.addLast(0);
                    backtrack(0, path);
                    return results;
                }

                void backtrack(int currNode, LinkedList<Integer> path) {
                    if (currNode == this.target) {
                        results.add(new ArrayList<>(path));
                    } else {
                        for (int n : graph[currNode]) {
                            path.addLast(n);
                            backtrack(n, path);
                            path.removeLast();
                        }
                    }
                }
            }
        }

        static class LetterCombinationsOfAPhoneNumber {

            static void run() {
                System.out.println("Letter Combinations of a Phone Number.");
                new Solution().letterCombinations("23").forEach((i) -> System.out.print(i + ","));
                System.out.println();
            }

            static class Solution {
                private List<String> combinations = new ArrayList<>();
                private Map<Character, String> letters = Map.of(
                        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
                private String phoneDigits;

                public List<String> letterCombinations(String digits) {
                    if (digits.length() == 0) {
                        return combinations;
                    }
                    phoneDigits = digits;
                    backtrack(0, new StringBuilder());
                    return combinations;
                }

                private void backtrack(int index, StringBuilder path) {
                    if (path.length() == phoneDigits.length()) {
                        combinations.add(path.toString());
                        return;
                    }

                    String possibleLetters = letters.get(phoneDigits.charAt(index));
                    for (char letter : possibleLetters.toCharArray()) {
                        path.append(letter);
                        backtrack(index + 1, path);
                        path.deleteCharAt(path.length() - 1);
                    }
                }
            }
        }
    }
}
