package m.d.a.m.p.ya.c8458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c8458d {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        calc(n, n, "");
    }

    static void calc(int left, int right, String out) {
        if (right == 0) {
            return;
        } else if (left == 0) {
            System.out.print(out);
            for (int i = 0; i < right; i++) {
                System.out.print(")");
            }
            System.out.println();
        } else if (right == left) {
            calc(left - 1, right, out + "(");
        } else {
            calc(left - 1, right, out + "(");
            calc(left, right - 1, out + ")");
        }
    }
}
