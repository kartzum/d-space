package m.d.a.m.p.cses.fi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=87liHXDe6Eo

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        // System.out.println(calc(2, 3));
        // System.out.println(calc(1, 1));
        // System.out.println(calc(4, 2));
        // System.out.println(calc(170550340, 943050741)); // 889344699930098742

        run();
    }

    static void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = input.readLine();
            lines.add(line);
        }
        for (String line : lines) {
            String[] values = line.split(" ");
            long y = Long.parseLong(values[0]);
            long x = Long.parseLong(values[1]);
            System.out.println(calc(y, x));
        }
    }

    static long calc(long y, long x) {
        if (x > y) {
            if (x % 2 == 1) {
                return x * x - y + 1;
            } else {
                x -= 1;
                return x * x + y;
            }
        } else {
            if (y % 2 == 0) {
                return y * y - x + 1;
            } else {
                y -= 1;
                return y * y + x;
            }
        }
    }
}
