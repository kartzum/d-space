package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.add(1);
        binaryTreeNode1.add(0);
        binaryTreeNode1.add(2);
        binaryTreeNode1.add(3);
        final List<Integer> l1 = new Solution().inorderTraversal(binaryTreeNode1.root);
        System.out.println(l1);

    }

    public static class BinaryTreeNode {
        TreeNode root;

        public void add(int val) {
            root = add(root, val);
        }

        private TreeNode add(TreeNode current, int val) {
            if (current == null) {
                return new TreeNode(val);
            }
            if (val < current.val) {
                current.left = add(current.left, val);
            } else if (val > current.val) {
                current.right = add(current.right, val);
            } else {
                return current;
            }
            return current;
        }
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            final List<Integer> list = new ArrayList<>();
            final Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.empty()) {
                while (cur != null) {
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
            return list;
        }
    }
}
