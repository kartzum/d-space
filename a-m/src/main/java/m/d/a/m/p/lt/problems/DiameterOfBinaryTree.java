package m.d.a.m.p.lt.problems;

public class DiameterOfBinaryTree {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new Solution().diameterOfBinaryTree(node1));
    }

    static class Solution {
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            helper(root);
            return ans - 1;
        }

        private int helper(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int l = helper(node.left);
            int r = helper(node.right);
            ans = Math.max(ans, l + r + 1);
            return Math.max(l, r) + 1;
        }
    }
}
