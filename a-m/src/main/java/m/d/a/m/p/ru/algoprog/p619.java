// https://algoprog.ru/material/p619

// https://hsecodes.com/index.php/tasksdecision/index/344

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p619 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] t = reader.readLine().toCharArray();
            for (int j = 0; j < t.length; j++) {
                a[i][j] = Integer.parseInt(t[j] + "");
            }
        }
        calc(a);
    }

    static void calc(int[][] a) {
        int n = a.length;

        int[][] s = new int[n][n];
        int[][] r = new int[n][n];

        s[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            s[0][i] = a[0][i] + s[0][i - 1];
            r[0][i] = 'l';
            s[i][0] = a[i][0] + s[i - 1][0];
            r[i][0] = 'u';
        }

        r[0][0] = 'i';
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                s[i][j] = a[i][j];
                if (s[i - 1][j] < s[i][j - 1]) {
                    s[i][j] += s[i - 1][j];
                    r[i][j] = 'u';
                } else {
                    s[i][j] += s[i][j - 1];
                    r[i][j] = 'l';
                }
            }
        }

        int x = n - 1, y = n - 1;
        boolean isEnd = false;
        do {
            int X = x, Y = y;
            if (r[x][y] == 'u') {
                x--;
            } else if (r[x][y] == 'l') {
                y--;
            } else if (r[x][y] == 'i') {
                isEnd = true;
            }
            r[X][Y] = '#';
        }
        while (!isEnd);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (r[i][j] != '#') {
                    System.out.print("-");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

}
