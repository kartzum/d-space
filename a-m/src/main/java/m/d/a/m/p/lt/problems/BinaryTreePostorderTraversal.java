package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.add(1);
        binaryTreeNode1.add(0);
        binaryTreeNode1.add(2);
        binaryTreeNode1.add(3);
        final List<Integer> l1 = new Solution().postorderTraversal(binaryTreeNode1.root);
        System.out.println(l1);
    }

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(0, node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return list;
        }
    }
}
