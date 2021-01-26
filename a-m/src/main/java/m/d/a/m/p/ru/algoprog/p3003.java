// https://algoprog.ru/material/p3003

// http://acm.mipt.ru/twiki/bin/view/Curriculum/FIVTLecturesTerm1Lecture6
// https://neerc.ifmo.ru/wiki/index.php?title=%D0%9D%D0%B0%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5_%D0%BA%D0%BE%D0%BB%D0%B8%D1%87%D0%B5%D1%81%D1%82%D0%B2%D0%B0_%D1%80%D0%B0%D0%B7%D0%B1%D0%B8%D0%B5%D0%BD%D0%B8%D0%B9_%D1%87%D0%B8%D1%81%D0%BB%D0%B0_%D0%BD%D0%B0_%D1%81%D0%BB%D0%B0%D0%B3%D0%B0%D0%B5%D0%BC%D1%8B%D0%B5
// https://github.com/Sur0vy/fragmentation/blob/master/src/com/company/FragmentationCount.java
// https://intuit.ru/studies/courses/648/504/lecture/11462?page=3

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int N = 200;
        int[][] m = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(m[i], -1);
        }
        System.out.println(split(n, k, m));
    }

    static int split(int n, int k, int[][] m) {
        if (n >= 0 && k >= 0 && m[n][k] > 0) {
            return m[n][k];
        }
        if (n == 1 || k == 1) {
            return 1;
        }
        if (n <= k) {
            m[n][k] = split(n, n - 1, m) + 1;
            return m[n][k];
        }
        m[n][k] = split(n, k - 1, m) + split(n - k, k, m);
        return m[n][k];
    }
}
