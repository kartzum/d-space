package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode();
        binaryTreeNode1.add(3);
        binaryTreeNode1.add(9);
        binaryTreeNode1.add(20);
        binaryTreeNode1.add(15);
        binaryTreeNode1.add(7);
        final List<List<Integer>> l1 = new Solution().levelOrder(binaryTreeNode1.root);
        System.out.println(l1);
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> r = new ArrayList<>();
                list.add(r);
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    r.add(node.val);
                }
            }
            return list;
        }
    }
}
