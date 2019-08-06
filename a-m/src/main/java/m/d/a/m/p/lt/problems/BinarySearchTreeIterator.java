package m.d.a.m.p.lt.problems;

import java.util.ArrayList;

public class BinarySearchTreeIterator {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        BSTIterator i = new BSTIterator(node2);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    static class BSTIterator {

        ArrayList<Integer> nodesSorted;
        int index;

        public BSTIterator(TreeNode root) {

            // Array containing all the nodes in the sorted order
            this.nodesSorted = new ArrayList<Integer>();

            // Pointer to the next smallest element in the BST
            this.index = -1;

            // Call to flatten the input binary search tree
            this._inorder(root);
        }

        private void _inorder(TreeNode root) {

            if (root == null) {
                return;
            }

            this._inorder(root.left);
            this.nodesSorted.add(root.val);
            this._inorder(root.right);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return this.nodesSorted.get(++this.index);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return this.index + 1 < this.nodesSorted.size();
        }
    }
}
