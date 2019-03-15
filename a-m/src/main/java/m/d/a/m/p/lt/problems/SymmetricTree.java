package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        final boolean l1 = new Solution().isSymmetric(treeNode);
        System.out.println(l1);
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isMirror(root.left, root.right);
        }

        boolean isMirror(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            return (l.val == r.val) && isMirror(l.right, r.left) && isMirror(l.left, r.right);
        }
    }

    static class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return false;
            }
            List<List<Integer>> left = calc(root.left);
            List<List<Integer>> right = calc(root.right);
            if (left == null || right == null || left.size() != right.size()) {
                return false;
            }
            for (int i = 0; i < left.size(); i++) {
                List<Integer> l = left.get(i);
                List<Integer> r = right.get(i);
                if (l.size() != r.size()) {
                    return false;
                }
                for (int j = 0; j < l.size(); j++) {
                    int lv = l.get(j);
                    int rv = r.get(l.size() - j - 1);
                    if (lv != rv) {
                        return false;
                    }
                }
            }
            return true;
        }

        List<List<Integer>> calc(TreeNode root) {
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
