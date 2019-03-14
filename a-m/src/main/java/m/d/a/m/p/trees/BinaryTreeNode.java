package m.d.a.m.p.trees;

import java.util.LinkedList;

public class BinaryTreeNode {
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

    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.val);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            traverseInOrder(node.right);
            System.out.println(node.val);
        }
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode current, int val) {
        if (current == null) {
            return false;
        }
        if (current.val == val) {
            return true;
        }
        return val < current.val
                ? contains(current.left, val)
                : contains(current.right, val);
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        final LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final TreeNode node = queue.remove();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
