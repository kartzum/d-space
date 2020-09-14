package m.d.a.m.p.ya.c1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        // int[] b = new int[]{1};
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = input.nextInt();
        }
        int m = run(b);
        for (int i = 0; i < m; i++) {
            System.out.println(b[i]);
        }
    }

    static int run(int[] b) {
        if (b == null) {
            return 0;
        }
        int n = b.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (b[i] != b[i + 1]) {
                b[j++] = b[i];
            }
        }
        b[j++] = b[n - 1];
        return j;
    }
}
