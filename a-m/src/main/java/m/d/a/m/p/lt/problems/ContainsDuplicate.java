package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 5, 3}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
