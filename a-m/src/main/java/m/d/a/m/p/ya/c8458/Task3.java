package m.d.a.m.p.ya.c8458;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        // int[] b = new int[]{0, 0, 0, 0, 0, 0, 0};
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = input.nextInt();
        }
        System.out.println(run(b));
    }

    static int run(int[] b) {
        int r = 0;
        if (b != null) {
            int i = 0;
            while (i < b.length) {
                int v = b[i];
                int j = i + 1;
                int temp = 1;
                while (j < b.length && v == 1 && v == b[j]) {
                    temp++;
                    j++;
                }
                if (v == 1 && temp > r) {
                    r = temp;
                }
                i = j;
            }
        }
        return r;
    }
}
