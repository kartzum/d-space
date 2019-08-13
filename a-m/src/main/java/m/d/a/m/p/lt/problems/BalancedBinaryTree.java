package m.d.a.m.p.lt.problems;

public class BalancedBinaryTree {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(new Solution().isBalanced(node2));
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            else
                return ((Math.abs(height(root.right) - height(root.left)) <= 1) &&
                        isBalanced(root.right) &&
                        isBalanced(root.left)
                );
        }

        public int height(TreeNode root) {
            if (root == null)
                return -1;
            else
                return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
