// https://algoprog.ru/material/p1009

// http://baspas.narod.ru/10olymp.html
// https://ru.stackoverflow.com/questions/1184457/%D0%9F%D0%BE%D0%BC%D0%BE%D0%B3%D0%B8%D1%82%D0%B5-%D1%80%D0%B5%D1%88%D0%B8%D1%82%D1%8C-%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D1%83-%D0%A1%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(calc(n));
    }

    static int calc(int n) {
        int num = 1;
        List<Integer> list = f(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
        Set<Integer> set = new HashSet<>(list);
        for (int i : set) {
            int a = map.get(i);
            int temp = i;
            while (temp < a) {
                a = a % 2 + a / 2;
                temp *= i;
            }
            num *= temp;
        }
        return num;
    }

    static List<Integer> f(int n) {
        List<Integer> result = new ArrayList<>();
        int d = 2;
        while (d * d <= n) {
            if (n % d == 0) {
                result.add(d);
                n /= d;
            } else {
                d += 1;
            }
        }
        if (n > 1) {
            result.add(n);
        }
        return result;
    }
}
