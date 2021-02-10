// https://algoprog.ru/material/p164

// https://www.cyberforum.ru/cpp-beginners/thread2253886.html

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p164 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nv = reader.readLine().split(" ");
        int n = Integer.parseInt(nv[0]);
        int v = Integer.parseInt(nv[1]);
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            g.add(l);
            String[] t = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(t[j]);
                if (k == 1) {
                    l.add(j);
                }
            }
        }
        System.out.println(calc(g, v - 1));
    }

    static void tests() {
        List<List<Integer>> g = new ArrayList<>();
        g.add(new ArrayList<>());
        g.add(new ArrayList<>());
        g.add(new ArrayList<>());
        g.get(0).add(1);
        g.get(0).add(2);
        g.get(1).add(0);
        g.get(2).add(0);
        System.out.println(calc(g, 0));
    }

    static int calc(List<List<Integer>> g, int v) {
        Set<Integer> visited = new HashSet<>();
        return dfs(g, visited, v);
    }

    static int dfs(List<List<Integer>> g, Set<Integer> visited, int v) {
        visited.add(v);
        int count = 1;
        for (int i : g.get(v)) {
            if (!visited.contains(i)) {
                count += dfs(g, visited, i);
            }
        }
        return count;
    }
}
