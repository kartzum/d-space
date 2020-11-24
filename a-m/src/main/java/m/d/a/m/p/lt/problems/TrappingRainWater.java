package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }

    static class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int current = 0;
            Stack<Integer> stack = new Stack<>();
            while (current < height.length) {
                while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int distance = current - stack.peek() - 1;
                    int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                    ans += distance * boundedHeight;
                }
                stack.push(current++);
            }
            return ans;
        }
    }
}
