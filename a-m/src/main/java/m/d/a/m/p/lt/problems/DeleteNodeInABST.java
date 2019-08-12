package m.d.a.m.p.lt.problems;

public class DeleteNodeInABST {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode r = new Solution().deleteNode(node2, 3);
        System.out.println(r.val);
    }

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return root;

            if (key < root.val)
                root.left = deleteNode(root.left, key);

            else if (key > root.val)
                root.right = deleteNode(root.right, key);

            else {
                if (root.left == null)
                    return root.right;

                else if (root.right == null)
                    return root.left;

                root.val = minValue(root.right);
                root.right = deleteNode(root.right, root.val);
            }

            return root;
        }

        private int minValue(TreeNode root) {
            int minv = root.val;

            while (root.left != null) {
                minv = root.left.val;
                root = root.left;
            }

            return minv;
        }
    }
}
