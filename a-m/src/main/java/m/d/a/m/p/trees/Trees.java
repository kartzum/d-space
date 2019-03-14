package m.d.a.m.p.trees;

public class Trees {

    public static void main(final String[] args) {
        test();
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
