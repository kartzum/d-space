package m.d.a.m.p.lt.problems;

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
}
