package m.d.a.m.p.common;

import java.util.Arrays;

public class RemoveElementSolution {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 3, 2, 3};
        int r = removeElement(a, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(r);
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
