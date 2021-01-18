package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
    public static void main(final String[] args) {
        test();
    }

    private static void test() {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int l = nums.length, r = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                    l = Math.min(l, stack.pop());
                stack.push(i);
            }
            stack.clear();
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                    r = Math.max(r, stack.pop());
                stack.push(i);
            }
            return r - l > 0 ? r - l + 1 : 0;
        }
    }
}
