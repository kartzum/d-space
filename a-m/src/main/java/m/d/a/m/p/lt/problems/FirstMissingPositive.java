package m.d.a.m.p.lt.problems;

public class FirstMissingPositive {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution().firstMissingPositive(new int[]{}));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            int index = 0;
            int n = nums.length;

            while (index < n) {
                if (nums[index] > 0 && nums[index] <= n) {
                    int currentIndexValue = nums[index];
                    int currentIndexValueAsIndexValue = nums[nums[index] - 1];
                    if (currentIndexValue != currentIndexValueAsIndexValue) {
                        swap(nums, index, nums[index] - 1);
                    } else {
                        index++;
                    }
                } else {
                    index++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            return nums.length + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
