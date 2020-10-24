package m.d.a.m.p.codility.tasks.a1;

import java.util.*;

public class Task2 {
    public static void main(final String[] args) {
        tests();
    }

    static class P {
        String name;
        int start;
        int finish;

        P() {
        }

        P(String name, int start, int finish) {
            this.name = name;
            this.start = start;
            this.finish = finish;
        }
    }

    static class PComparator implements Comparator<P> {
        public int compare(P p1, P p2) {
            if (p1.start > p2.start)
                return 1;
            else if (p1.start < p2.start)
                return -1;
            return 0;
        }
    }

    public static int solution(String S) {
        // write your code in Java SE 8

        boolean debug = false;

        PriorityQueue<P> pq = new PriorityQueue<P>(5, new PComparator());

        String[] times = S.split("\n");

        for (int i = 0; i < times.length; i++) {
            String time = times[i];
            String day = time.substring(0, 3);
            String startH = time.substring(4, 6);
            String startM = time.substring(7, 9);
            String finishH = time.substring(10, 12);
            String finishM = time.substring(13, 15);
            int dayI = 0;
            switch (day) {
                case "Mon":
                    dayI = 0;
                    break;
                case "Tue":
                    dayI = 1;
                    break;
                case "Wed":
                    dayI = 2;
                    break;
                case "Thu":
                    dayI = 3;
                    break;
                case "Fri":
                    dayI = 4;
                    break;
                case "Sat":
                    dayI = 5;
                    break;
                case "Sun":
                    dayI = 6;
                    break;
            }
            int start = dayI * 24 * 60 + Integer.parseInt(startH) * 60 + Integer.parseInt(startM);
            int finish = dayI * 24 * 60 + Integer.parseInt(finishH) * 60 + Integer.parseInt(finishM);
            if (debug) {
                System.out.println(day + ", " + startH + ", " + startM + ", " + finishH + ", " + finishM + ", " + start + ", " + finish);
            }
            pq.add(new P(time, start, finish));
        }

        pq.add(new P("Sun", 6 * 24 * 60 + 24 * 60, 6 * 24 * 60 + 24 * 60));

        int max = Integer.MIN_VALUE;
        P prev = null;
        while (!pq.isEmpty()) {
            P p = pq.poll();
            if (prev == null) {
                prev = p;
                p = pq.poll();
            }
            int d = p.start - prev.finish;
            if (d > max) {
                max = d;
            }
            if (debug) {
                System.out.println(
                        prev.name + ", " +
                                p.name + ", " +
                                p.start + ", " +
                                p.finish + ", " + prev.start + ", " + prev.finish + ", " + (p.start - prev.finish));
            }
            prev = p;
        }
        if (debug) {
            System.out.println(max);
        }
        return max;
    }

    static void tests() {
        test1();
    }

    static void test1() {
        String S = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00";

        System.out.println(solution(S));
    }
}
