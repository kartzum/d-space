package m.d.a.m.p.sorts;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 1, 3, 9};
        System.out.println(Arrays.toString(items));
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int m = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j] < items[m]) {
                    m = j;
                }
            }
            int t = items[i];
            items[i] = items[m];
            items[m] = t;
        }
    }
}
