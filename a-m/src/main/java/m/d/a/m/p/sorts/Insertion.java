package m.d.a.m.p.sorts;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 1, 3, 9};
        System.out.println(Arrays.toString(items));
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items) {
        for (int i = 1; i < items.length; i++) {
            for (int j = i; j > 0 && items[j] < items[j - 1]; j--) {
                int t = items[j];
                items[j] = items[j - 1];
                items[j - 1] = t;
            }
        }
    }
}
