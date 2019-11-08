package m.d.a.m.p.lt.problems;

/**
 * https://ru.stackoverflow.com/questions/758529/%D0%9F%D0%B5%D1%80%D0%B5%D1%81%D0%B5%D1%87%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B4%D0%B2%D1%83%D1%85-%D0%BF%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2-c
 */
public class RectangleOverlap {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        System.out.println(new Solution().isRectangleOverlap(
                new int[]{0, 0, 2, 2}, new int[]{1, 1, 2, 2}));
    }

    static class Solution {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                    Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
        }
    }
}
