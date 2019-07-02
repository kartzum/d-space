package m.d.a.m.p.lt.problems;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        System.out.println(new Solution().sortedArrayToBST(nums));
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null) {
                return null;
            }
            return createBST(nums, 0, nums.length - 1);
        }

        private TreeNode createBST(int[] sortedArray, int startIndex, int endIndex) {
            if (startIndex > endIndex) {
                return null;
            }
            int mid = (startIndex + endIndex) / 2;
            TreeNode root = new TreeNode(sortedArray[mid]);
            root.left = createBST(sortedArray, startIndex, mid - 1);
            root.right = createBST(sortedArray, mid + 1, endIndex);
            return root;
        }
    }
}
