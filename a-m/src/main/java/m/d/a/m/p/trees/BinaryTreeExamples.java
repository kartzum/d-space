package m.d.a.m.p.trees;

public class BinaryTreeExamples {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.inOrder();
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
