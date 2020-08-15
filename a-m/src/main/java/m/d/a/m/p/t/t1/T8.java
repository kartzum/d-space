package m.d.a.m.p.t.t1;

import java.util.Arrays;

public class T8 {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        quick(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
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
