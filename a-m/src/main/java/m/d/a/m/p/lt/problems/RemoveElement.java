package m.d.a.m.p.lt.problems;

public class RemoveElement {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        System.out.println(new Solution().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new Solution().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(new Solution().removeElement(new int[]{2}, 3));
        System.out.println(new Solution().removeElement(new int[]{1}, 1));
        System.out.println(new Solution().removeElement(new int[]{0, 4, 4, 0, 4, 4, 40, 2}, 4));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }

    static class Solution2 {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }
            int index = 0;
            int size = nums.length;
            while (index < size) {
                if (nums[index] == val) {
                    int index2 = index;
                    while (index2 < size && nums[index2] == val) {
                        index2++;
                    }
                    int i = index2;
                    int k = 0;
                    while (i < size) {
                        nums[index + k] = nums[i];
                        i++;
                        k++;
                    }
                    int s = index2 - index;
                    index = index2;
                    size = size - s;
                } else {
                    index++;
                }
            }
            return size;
        }
    }
}
