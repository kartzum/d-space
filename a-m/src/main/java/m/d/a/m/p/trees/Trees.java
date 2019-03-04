package m.d.a.m.p.trees;

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

        public void add(int value) {
            root = add(root, value);
        }

        private TreeNode add(TreeNode current, int value) {
            if (current == null) {
                return new TreeNode(value);
            }
            if (value < current.val) {
                current.left = add(current.left, value);
            } else if (value > current.val) {
                current.right = add(current.right, value);
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
    }

    static void test() {
        final BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.add(6);
        binaryTreeNode.add(4);
        binaryTreeNode.add(8);
        binaryTreeNode.add(10);
        binaryTreeNode.add(12);
        binaryTreeNode.traverseInOrder(binaryTreeNode.root);
        System.out.println(binaryTreeNode.root.val);
    }
}
