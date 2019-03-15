package m.d.a.m.p.lt.problems;

public class PathSum {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution().hasPathSum(root, 22));
    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            return calc(root, sum);
        }

        boolean calc(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.val == sum && root.left == null && root.right == null) {
                return true;
            }
            return calc(root.left, sum - root.val) || calc(root.right, sum - root.val);
        }
    }
}
