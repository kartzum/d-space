package m.d.a.m.p.lt.problems;

public class ValidateBinarySearchTree {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(new Solution().isValidBST(node2));
    }

    static class Solution {
        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) return true;

            int val = node.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            if (!helper(node.right, val, upper)) return false;
            if (!helper(node.left, lower, val)) return false;
            return true;
        }

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }
    }
}
