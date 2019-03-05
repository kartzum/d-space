package m.d.a.m.p.trees;

import java.util.LinkedList;

public class Trees {

    public static void main(final String[] args) {
        test();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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

    static void test() {
        final BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.add(6);
        binaryTreeNode.add(4);
        binaryTreeNode.add(8);
        binaryTreeNode.add(10);
        binaryTreeNode.add(12);
        System.out.println("--1--");
        binaryTreeNode.traverseInOrder(binaryTreeNode.root);
        System.out.println("--2--");
        System.out.println(binaryTreeNode.root.val);
        System.out.println("--3--");
        System.out.println(binaryTreeNode.contains(8));
        System.out.println(binaryTreeNode.contains(14));
        System.out.println("--4--");
        binaryTreeNode.traversePreOrder(binaryTreeNode.root);
        System.out.println("--5--");
        binaryTreeNode.traversePostOrder(binaryTreeNode.root);
        System.out.println("--6--");
        binaryTreeNode.traverseLevelOrder();
    }
}
