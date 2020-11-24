package m.d.a.m.p.lt.problems;

public class NumberOfGoodPairs {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int[] op = new int[101];
            int c = 0;
            for (int i : nums) {
                c += op[i]++;
            }
            return c;
        }
    }
}
