package m.d.a.m.p.sorts;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 1, 3, 9};
        System.out.println(Arrays.toString(items));
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    private static void sort(int[] items, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(items, lo, hi);
        sort(items, lo, j - 1);
        sort(items, j + 1, hi);
    }

    private static int partition(int[] items, int lo, int hi) {
        boolean log = false;
        int i = lo;
        int j = hi + 1;
        int v = items[lo];
        while (true) {
            while (items[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < items[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int t = items[i];
            items[i] = items[j];
            items[j] = t;
            if (log) {
                System.out.println(Arrays.toString(items));
            }
        }
        int t = items[lo];
        items[lo] = items[j];
        items[j] = t;
        return j;
    }
}
