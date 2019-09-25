package m.d.a.m.p.trees;

public class BinaryTreeExamples {
    public static void main(final String[] args) {
        // test1();
        // test2();
        test3();
    }

    private static void test1() {
        BinaryTree binaryTree = create1();
        binaryTree.inOrder();
    }

    private static void test2() {
        BinaryTree binaryTree = create1();
        // BinaryTree binaryTree1 = new BinaryTree();
        TreeNode node = binaryTree.find(6);
        if (node != null) {
            System.out.println(node.val);
        }
    }

    private static void test3() {
        BinaryTree binaryTree = create1();
        TreeNode min = binaryTree.min();
        if (min != null) {
            System.out.println(min.val);
        }
        TreeNode max = binaryTree.max();
        if (max != null) {
            System.out.println(max.val);
        }
    }

    private static BinaryTree create1() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(6);
        return binaryTree;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class BinaryTree {
        TreeNode root;

        void insert(int val) {
            TreeNode node = new TreeNode(val);
            if (root == null) {
                root = node;
            } else {
                TreeNode current = root;
                TreeNode parent;
                while (true) {
                    parent = current;
                    if (val < current.val) {
                        current = current.left;
                        if (current == null) {
                            parent.left = node;
                            return;
                        }
                    } else {
                        current = current.right;
                        if (current == null) {
                            parent.right = node;
                            return;
                        }
                    }
                }
            }
        }

        TreeNode find(int val) {
            TreeNode current = root;
            while (current != null && current.val != val) {
                if (val < current.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return current;
        }

        TreeNode min() {
            TreeNode current = root;
            TreeNode last = null;
            while (current != null) {
                last = current;
                current = current.left;
            }
            return last;
        }

        TreeNode max() {
            TreeNode current = root;
            TreeNode last = null;
            while (current != null) {
                last = current;
                current = current.right;
            }
            return last;
        }

        void inOrder() {
            inOrderInner(root);
        }

        void inOrderInner(TreeNode node) {
            if (node != null) {
                inOrderInner(node.left);
                System.out.println(node.val);
                inOrderInner(node.right);
            }
        }
    }
}
