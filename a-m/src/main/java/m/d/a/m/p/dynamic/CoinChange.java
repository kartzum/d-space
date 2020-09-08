package m.d.a.m.p.dynamic;

import java.util.Arrays;

// https://www.geeksforgeeks.org/coin-change-dp-7/

public class CoinChange {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(countR(arr, m, 4));
    }

    static void test2() {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(countWays(arr, m, n));
    }

    static int countR(int S[], int m, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (m <= 0 && n >= 1)
            return 0;
        return countR(S, m - 1, n) +
                countR(S, m, n - S[m - 1]);
    }

    static long countWays(int S[], int m, int n) {
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }
}
