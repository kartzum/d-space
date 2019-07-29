package m.d.a.m.p.trees;

/**
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class Traversals {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        new InOrder().run(create());
        System.out.println();
        new PreOrder().run(create());
        System.out.println();
        new PostOrder().run(create());
    }

    private static class InOrder {
        void run(TreeNode node) {
            if (node == null) {
                return;
            }
            run(node.left);
            System.out.print(node.val);
            run(node.right);
        }
    }

    private static class PreOrder {
        void run(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.val);
            run(node.left);
            run(node.right);
        }
    }

    private static class PostOrder {
        void run(TreeNode node) {
            if (node == null) {
                return;
            }
            run(node.left);
            run(node.right);
            System.out.print(node.val);
        }
    }

    private static TreeNode create() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        return node1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
