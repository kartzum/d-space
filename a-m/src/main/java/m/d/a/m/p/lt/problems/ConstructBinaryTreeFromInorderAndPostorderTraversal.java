package m.d.a.m.p.lt.problems;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    static void test1() {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        System.out.println(new Solution().buildTree(inorder, postorder));
    }

    static void test2() {
        int[] inorder = new int[]{2, 1};
        int[] postorder = new int[]{2, 1};
        System.out.println(new Solution().buildTree(inorder, postorder));
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length <= 0 || postorder.length <= 0) {
                return null;
            }
            Map<Integer, Integer> inOrderMap = new HashMap<>();
            Map<Integer, Integer> postOrderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inOrderMap.put(inorder[i], i);
            }
            for (int i = 0; i < postorder.length; i++) {
                postOrderMap.put(postorder[i], i);
            }
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            List<Integer> h = new ArrayList<>();
            h.add(root.val);
            while (!s.isEmpty()) {
                TreeNode node = s.pop();
                int indexIn = inOrderMap.get(node.val);
                TreeNode left = null;
                if (indexIn - 1 >= 0) {
                    int v = inorder[indexIn - 1];
                    if (!h.contains(v)) {
                        left = new TreeNode(v);
                        h.add(left.val);
                    }
                }
                node.left = left;
                int indexPost = postOrderMap.get(node.val);
                TreeNode right = null;
                if (indexPost - 1 >= 0) {
                    int v = postorder[indexPost - 1];
                    if (!h.contains(v)) {
                        right = new TreeNode(v);
                        h.add(right.val);
                    }
                }
                node.right = right;
                if (left != null) {
                    s.push(left);
                }
                if (right != null) {
                    s.push(right);
                }
            }

            return root;
        }
    }
}
