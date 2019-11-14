package m.d.a.m.p.lt.problems;

import java.util.HashSet;

public class SubtreeOfAnotherTree {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode sn1 = new TreeNode(1);
        TreeNode tn1 = new TreeNode(1);
        System.out.println(new Solution().isSubtree(sn1, tn1));
    }

    public static class Solution {
        HashSet<String> trees = new HashSet<>();

        public boolean isSubtree(TreeNode s, TreeNode t) {
            String tree1 = preorder(s, true);
            String tree2 = preorder(t, true);
            return tree1.indexOf(tree2) >= 0;
        }

        public String preorder(TreeNode t, boolean left) {
            if (t == null) {
                if (left)
                    return "lnull";
                else
                    return "rnull";
            }
            return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
        }
    }
}
