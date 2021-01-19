// https://algoprog.ru/material/p210

// https://hsecodes.com/index.php/tasksdecision/index/80

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p210 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        String[] t = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(t[i]);
        }
        System.out.println(calc(a));
    }

    static int calc(int[] a) {
        if (a.length == 2) {
            return a[1] + a[0];
        }
        Arrays.sort(a);
        List<Integer> s = new ArrayList<>(a.length);
        s.add(a[1] - a[0]);
        s.add(a[2] - a[0]);
        for (int i = 2; i < a.length - 1; ++i) {
            s.add(Math.min(s.get(i - 1), s.get(i - 2)) + Math.abs(a[i] - a[i + 1]));
        }
        return s.get(s.size() - 1);
    }
}
