package m.d.a.m.p.ya.c19036;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        boolean log = true;
        boolean test = true;
        if (test) {
            calcTest1(log);
        }
    }

    private static void calcTest1(boolean log) {
        List<Integer> timers = new ArrayList<>();
        timers.add(1);
        timers.add(2);
        timers.add(3);
        timers.add(4);
        timers.add(5);
        timers.add(6);
        int step = 5;
        int finish = 10;
        int r = calc(timers, step, finish, log);
        if (log) {
            System.out.println(r);
        }
    }

    private static int calc(List<Integer> timers, int step, int finish, boolean log) {
        int j = 1;
        while (j < 5) {
            for (int i = 0; i < timers.size(); i++) {
                int vPrev = timers.get(i);
                int c = vPrev + step * j;
                timers.set(i, c);
            }
            for (int i = 0; i < timers.size(); i++) {
                System.out.print(timers.get(i) + " ");
            }
            System.out.println();
            j++;
        }
        return 0;
    }
}
