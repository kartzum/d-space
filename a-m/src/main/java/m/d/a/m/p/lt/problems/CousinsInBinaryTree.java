package m.d.a.m.p.lt.problems;

public class CousinsInBinaryTree {

    public static void main(final String[] args) {
        test();
    }

    static void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(new Solution().isCousins(node1, 2, 3));
    }

    static void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        System.out.println(new Solution().isCousins(node1, 5, 4));
    }

    static class Solution {
        int xDepth;
        int yDepth;
        TreeNode xParentNode;
        TreeNode yParentNode;

        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) return false;
            calc(root, null, 0, x, y);
            return xParentNode != yParentNode && xDepth == yDepth;
        }

        private void calc(TreeNode current, TreeNode parent, int depth, int x, int y) {
            if (current == null) {
                return;
            }
            if (current.val == x) {
                xDepth = depth;
                xParentNode = parent;
            }
            if (current.val == y) {
                yDepth = depth;
                yParentNode = parent;
            }
            calc(current.left, current, depth + 1, x, y);
            calc(current.right, current, depth + 1, x, y);
        }
    }
}
