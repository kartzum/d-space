package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestBinarySearchTreeValue {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        System.out.println(new Solution().closestValue(node4, 2.3));
    }

    static class Solution {
        public int closestValue(TreeNode root, double target) {
            List<Integer> nums = new ArrayList<>();
            calc(root, nums);
            return Collections.min(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
                }
            });
        }

        private void calc(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            calc(root.left, nums);
            nums.add(root.val);
            calc(root.right, nums);
        }
    }
}
