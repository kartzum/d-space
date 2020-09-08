package m.d.a.m.p.dynamic;

// https://www.geeksforgeeks.org/binomial-coefficient-dp-9/

public class Ckn {
    public static void main(String[] args) {
        System.out.println(calc(5, 2));
    }

    static int calc(int n, int k) {
        int m[][] = new int[n + 1][k + 1];
        int i, j;

        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    m[i][j] = 1;
                else
                    m[i][j] = m[i - 1][j - 1] + m[i - 1][j];
            }
        }

        return m[n][k];
    }
}
