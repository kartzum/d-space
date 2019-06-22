package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(new Solution().buildTree(preorder, inorder));
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int N = preorder.length;
            if (N == 0) return null;
            TreeNode root = new TreeNode(preorder[0]);
            if (N == 1) return root;

            int L = 0;
            for (int i = 0; i < N; ++i) {
                if (inorder[i] == preorder[0])
                    L = i;
            }
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, L + 1),
                    Arrays.copyOfRange(inorder, 0, L));
            root.right = buildTree(Arrays.copyOfRange(preorder, L + 1, N), Arrays.copyOfRange(inorder, L + 1, N));
            return root;
        }
    }
}
