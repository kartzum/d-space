package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().generateTrees(3));
    }

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return helper(1, n);
        }

        private List<TreeNode> helper(int a, int b) {
            List<TreeNode> ret = new ArrayList<>();
            if (a > b) {
                ret.add(null);
                return ret;
            }
            for (int i = a; i <= b; i++) {
                List<TreeNode> l = helper(a, i - 1);
                List<TreeNode> r = helper(i + 1, b);
                for (TreeNode ll : l) {
                    for (TreeNode rr : r) {
                        TreeNode node = new TreeNode(i);
                        node.left = ll;
                        node.right = rr;
                        ret.add(node);
                    }
                }
            }
            return ret;
        }
    }
}
