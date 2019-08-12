package m.d.a.m.p.lt.problems;

public class InsertIntoABinarySearchTree {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode r = new Solution().insertIntoBST(node2, 5);
        System.out.println(r.val);
    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                root = new TreeNode(val);
                return root;
            }

            if (root.left == null && root.right == null) {
                if (root.val <= val)
                    root.right = new TreeNode(val);
                else
                    root.left = new TreeNode(val);

                return root;
            }

            if (root.val <= val)
                root.right = insertIntoBST(root.right, val);

            else
                root.left = insertIntoBST(root.left, val);

            return root;
        }
    }
}
