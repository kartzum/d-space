package m.d.a.m.p.lt.problems;

public class RangeSumOfBST {

    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(new Solution().rangeSumBST(treeNode1, 2, 3));
    }

    static class Solution {
        int v;
        int l;
        int r;

        public int rangeSumBST(TreeNode root, int L, int R) {
            v = 0;
            l = L;
            r = R;
            traverse(root);
            return v;
        }

        private void traverse(TreeNode n) {
            if (n == null) {
                return;
            }
            traverse(n.left);
            if (n.val >= l && n.val <= r) {
                v += n.val;
            }
            traverse(n.right);
        }
    }
}
