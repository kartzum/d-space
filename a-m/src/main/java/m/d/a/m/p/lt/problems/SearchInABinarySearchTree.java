package m.d.a.m.p.lt.problems;

public class SearchInABinarySearchTree {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode r = new Solution().searchBST(node2, 3);
        if (r != null) {
            System.out.println(r.val);
        }
    }

    static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if (root.val == val)
                return root;
            if (val < root.val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);
        }
    }
}
