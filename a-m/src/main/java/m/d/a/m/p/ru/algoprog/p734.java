// https://algoprog.ru/material/p734

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p734 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Pair> dists = new ArrayList<>();
        int i = 0;
        for (String s : reader.readLine().split(" ")) {
            dists.add(new Pair(i, Integer.parseInt(s)));
            i++;
        }
        List<Pair> tariffs = new ArrayList<>();
        int j = 0;
        for (String s : reader.readLine().split(" ")) {
            tariffs.add(new Pair(j, Integer.parseInt(s)));
            j++;
        }
        List<Integer> result = calc(dists, tariffs);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    static void tests() {
        List<Pair> dists = new ArrayList<>();
        dists.add(new Pair(0, 10));
        dists.add(new Pair(1, 20));
        dists.add(new Pair(2, 30));
        List<Pair> tariffs = new ArrayList<>();
        tariffs.add(new Pair(0, 50));
        tariffs.add(new Pair(1, 20));
        tariffs.add(new Pair(2, 30));
        List<Integer> result = calc(dists, tariffs);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    static class Pair {
        int i;
        int x;

        Pair() {
        }

        Pair(int i, int x) {
            this.i = i;
            this.x = x;
        }
    }

    static List<Integer> calc(List<Pair> dists, List<Pair> tariffs) {
        List<Integer> result = new ArrayList<>();
        Collections.sort(dists, (o1, o2) -> o1.x - o2.x);
        Collections.sort(tariffs, (o1, o2) -> o2.x - o1.x);
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < dists.size(); i++) {
            pairs.add(new Pair(dists.get(i).i, tariffs.get(i).i));
        }
        Collections.sort(pairs, (o1, o2) -> o1.i - o2.i);
        for (int i = 0; i < dists.size(); i++) {
            result.add(pairs.get(i).x + 1);
        }
        return result;
    }
}
