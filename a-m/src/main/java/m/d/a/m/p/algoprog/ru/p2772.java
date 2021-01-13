// https://algoprog.ru/material/p2772

// https://brestprog.by/topics/prefixsums/

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2772 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nmk = reader.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int[][] pref = new int[n][m];
        pref[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            pref[i][0] = pref[i - 1][0] + a[i][0];
        }
        for (int i = 1; i < m; i++) {
            pref[0][i] = pref[0][i - 1] + a[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                pref[i][j] = pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1] + a[i][j];
            }
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] temp = reader.readLine().split(" ");
            int x1 = Integer.parseInt(temp[0])-1;
            int y1 = Integer.parseInt(temp[1])-1;
            int x2 = Integer.parseInt(temp[2])-1;
            int y2 = Integer.parseInt(temp[3])-1;
            buffer.append(query(pref, x1, y1, x2, y2));
            buffer.append("\n");
        }
        System.out.println(buffer.toString());
    }

    static long query(int[][] pref, int x1, int y1, int x2, int y2) {
        int x1_ = x1 - 1 >= 0 ? pref[x1 - 1][y2] : 0;
        int y1_ = y1 - 1 >= 0 ? pref[x2][y1 - 1] : 0;
        int x1y1_ = x1 - 1 >= 0 && y1 - 1 >= 0 ? pref[x1 - 1][y1 - 1] : 0;
        return pref[x2][y2] - x1_ - y1_ + x1y1_;
    }
}
