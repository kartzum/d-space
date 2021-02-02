// https://algoprog.ru/material/p174

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p174 {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int z = 0;
        for (int i = 0; i < n; i++) {
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                z += Integer.parseInt(t[j]);
            }
        }
        System.out.println(z / 2);
    }
}
