package m.d.a.m.p.lt.problems;

public class SameTree {
    public static void main(final String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

        final boolean l1 = new Solution().isSameTree(treeNode1, treeNode2);
        System.out.println(l1);
    }

    private static void test2() {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = null;

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = null;
        treeNode2.right = new TreeNode(2);

        final boolean l1 = new Solution().isSameTree(treeNode1, treeNode2);
        System.out.println(l1);
    }

    private static void test3() {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(2);

        final boolean l1 = new Solution().isSameTree(treeNode1, treeNode2);
        System.out.println(l1);
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
