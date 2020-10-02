package m.d.a.m.p.lt.problems;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(new Solution().findKthLargest(nums, 2));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
            for (int n : nums) {
                queue.add(n);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.poll();
        }
    }
}
