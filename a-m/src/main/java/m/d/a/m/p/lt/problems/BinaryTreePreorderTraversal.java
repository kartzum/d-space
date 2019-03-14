package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.add(1);
        binaryTreeNode1.add(0);
        binaryTreeNode1.add(2);
        binaryTreeNode1.add(3);
        final List<Integer> l1 = new Solution().preorderTraversal(binaryTreeNode1.root);
        System.out.println(l1);
    }

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                while (node != null) {
                    list.add(node.val);
                    stack.push(node.right);
                    node = node.left;
                }
            }
            return list;
        }
    }
}
