package m.d.a.m.p.common;

import java.util.Arrays;

public class ReverseSolution {
    public static void main(String[] args) {
        int[] v = new int[]{3, 2, 1};
        reverse(v);
        System.out.println(Arrays.toString(v));
    }

    private static void reverse(int[] v) {
        int i = 0;
        int j = v.length - 1;
        while (i < j) {
            int t = v[i];
            v[i] = v[j];
            v[j] = t;
            i++;
            j--;
        }
    }
}
