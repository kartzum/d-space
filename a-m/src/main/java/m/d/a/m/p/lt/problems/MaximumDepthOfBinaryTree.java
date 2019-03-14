package m.d.a.m.p.lt.problems;

public class MaximumDepthOfBinaryTree {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.add(1);
        binaryTreeNode1.add(0);
        binaryTreeNode1.add(2);
        binaryTreeNode1.add(3);
        final int l1 = new Solution().maxDepth(binaryTreeNode1.root);
        System.out.println(l1);
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
