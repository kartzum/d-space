package m.d.a.m.p.dynamic;

import java.util.Arrays;

/**
 * https://e-maxx.ru/algo/maximum_average_segment
 * https://acm.khpnets.info/w/index.php?title=%D0%94%D0%B8%D0%BD%D0%B0%D0%BC%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5_%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5
 */
public class MaxArraySum {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution1().calc(new int[]{-2, 1, 3, -4, 5}));
        System.out.println(new Solution2().calc(new int[]{-2, 1, 3, -4, 5}));
    }

    static class Solution1 {
        int calc(int[] arr) {
            int s = arr[0];
            int prev = 0;

            for (int i = 0; i < arr.length; i++) {
                int prevOld = prev;
                prev = Math.max(prev, s);
                s = arr[i] + prevOld;
            }

            return Math.max(s, prev);
        }
    }

    static class Solution2 {
        int calc(int[] a) {
            int[] d = new int[a.length];
            d[0] = a[0];
            for (int i = 1; i < a.length; i++) {
                d[i] = Math.max(d[i - 1] + a[i], a[i]);
            }
            Arrays.sort(d);
            return d[d.length - 1];
        }
    }
}
