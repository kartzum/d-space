package m.d.a.m.p.trees;

public class TreeTasks {
    public static void main(String[] args) {
        System.out.println(T530MinimumAbsoluteDifferenceInBST.class.getSimpleName());

        System.out.println(new T530MinimumAbsoluteDifferenceInBST.Solution().getMinimumDifference(createTreeNode()));
    }

    public static class T530MinimumAbsoluteDifferenceInBST {
        static class Solution {
            int min = Integer.MAX_VALUE;
            int rootValue = Integer.MAX_VALUE;

            public int getMinimumDifference(TreeNode root) {
                min = Integer.MAX_VALUE;
                rootValue = Integer.MAX_VALUE;
                inOrder(root);
                return min;
            }

            private void inOrder(TreeNode root) {
                if (root == null) {
                    return;
                }
                inOrder(root.left);
                if (rootValue != Integer.MAX_VALUE) {
                    min = Math.min(min, Math.abs(rootValue - root.val));
                }
                rootValue = root.val;
                inOrder(root.right);
            }
        }
    }

    private static TreeNode createTreeNode() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode6;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        return treeNode4;
    }
}
