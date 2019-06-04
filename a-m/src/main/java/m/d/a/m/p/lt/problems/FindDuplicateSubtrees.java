package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode tn0_1 = new TreeNode(1);
        TreeNode tn1_2 = new TreeNode(2);
        TreeNode tn1_3 = new TreeNode(3);
        TreeNode tn2_4 = new TreeNode(4);
        TreeNode tn2_2 = new TreeNode(2);
        TreeNode tn2_4_1 = new TreeNode(4);
        TreeNode tn3_4 = new TreeNode(4);

        tn0_1.left = tn1_2;
        tn0_1.right = tn1_3;

        tn1_2.left = tn2_4;

        tn1_3.left = tn2_2;
        tn1_3.right = tn2_4_1;

        tn2_2.right = tn3_4;

        List<TreeNode> nodes = new Solution().findDuplicateSubtrees(tn0_1);
        for (TreeNode tn : nodes) {
            System.out.println(tn.val);
        }
    }

    static class Solution {
        Map<String, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap<>();
            ans = new ArrayList<>();
            collect(root);
            return ans;
        }

        public String collect(TreeNode node) {
            if (node == null) return "#";
            String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
            count.put(serial, count.getOrDefault(serial, 0) + 1);
            if (count.get(serial) == 2)
                ans.add(node);
            return serial;
        }
    }
}
