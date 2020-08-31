package m.d.a.m.p.sorts;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] items = new int[]{5, 7, 1, 3, 9};
        System.out.println(Arrays.toString(items));
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    private static void sort(int[] items) {
        int n = items.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j + 1];
                    items[j + 1] = items[j];
                    items[j] = temp;
                }
            }
        }
    }
}
