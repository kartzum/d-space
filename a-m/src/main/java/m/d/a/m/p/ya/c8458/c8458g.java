package m.d.a.m.p.ya.c8458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class c8458g {
    public static void main(String[] args) throws IOException {
        //tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Pair[] coord = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = reader.readLine().split(" ");
            coord[i] = new Pair(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        int k = Integer.parseInt(reader.readLine());
        String[] tmp = reader.readLine().split(" ");
        int departure = Integer.parseInt(tmp[0]) - 1;
        int arrival = Integer.parseInt(tmp[1]) - 1;
        System.out.println(calc(n, coord, k, departure, arrival));
    }

    static void tests() {
        System.out.println(calc(7, new Pair[]{
                new Pair(0, 0),
                new Pair(0, 2),
                new Pair(2, 2),
                new Pair(0, -2),
                new Pair(2, -2),
                new Pair(2, -1),
                new Pair(2, 1),
        }, 2, 1, 3));
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int calc(int n, Pair[] coord, int k, int departure, int arrival) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(departure, 0));
        Set<Integer> visited = new HashSet<>();
        visited.add(departure);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int currCity = p.x;
            int currCityRoads = p.y;
            if (currCity == arrival) {
                return currCityRoads;
            }
            for (int city = 0; city < n; city++) {
                if (distance(coord[city], coord[currCity]) <= k && !visited.contains(city)) {
                    q.add(new Pair(city, currCityRoads + 1));
                    visited.add(city);
                }
            }
        }
        return -1;
    }

    static int distance(Pair p1, Pair p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
