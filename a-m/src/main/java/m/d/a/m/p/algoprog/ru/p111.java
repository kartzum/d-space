// https://algoprog.ru/material/p111

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p111 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String v = r.readLine();
        while (v != null) {
            list.add(v);
            v = r.readLine();
        }

        long x = 0;
        long y = 0;
        for (String c : list) {
            String[] a = c.split(" ");
            String direction = a[0];
            long value = Long.parseLong(a[1]);
            switch (direction) {
                case "East":
                    x += value;
                    break;
                case "West":
                    x -= value;
                    break;
                case "North":
                    y += value;
                    break;
                case "South":
                    y -= value;
                    break;
            }
        }
        System.out.println(x + " " + y);
    }
}
