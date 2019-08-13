package m.d.a.m.p.lt.problems;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode r = new Solution().lowestCommonAncestor(node2, node1, node3);
        System.out.println(r.val);
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // Value of current node or parent node.
            int parentVal = root.val;

            // Value of p
            int pVal = p.val;

            // Value of q;
            int qVal = q.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                return lowestCommonAncestor(root.right, p, q);
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                return lowestCommonAncestor(root.left, p, q);
            } else {
                // We have found the split point, i.e. the LCA node.
                return root;
            }
        }
    }

}
