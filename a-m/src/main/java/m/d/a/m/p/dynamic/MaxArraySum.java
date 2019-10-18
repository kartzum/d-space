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
            if (arr.length == 0) return 0;
            arr[0] = Math.max(0, arr[0]);
            if (arr.length == 1) return arr[0];
            arr[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < arr.length; i++)
                arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
            return arr[arr.length - 1];
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
