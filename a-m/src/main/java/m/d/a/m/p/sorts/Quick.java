package m.d.a.m.p.sorts;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 1, 3, 9};
        System.out.println(Arrays.toString(items));
        quick(items, 0, items.length - 1);
        System.out.println(Arrays.toString(items));
    }

    public static void quick(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int m = low + (high - low) / 2;
        int v = a[m];
        int i = low;
        int j = high;
        while (i <= j) {
            while (a[i] < v) {
                i++;
            }
            while (a[j] > v) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quick(a, low, j);
        }
        if (high > i) {
            quick(a, i, high);
        }
    }
}
