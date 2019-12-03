package m.d.a.m.p.hse.m1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://tproger.ru/articles/dynprog-starters/
 * https://server.179.ru/tasks/python/2022a/pgm14.6__Dynamic_programming.html#prob_I
 * https://informatics.mccme.ru/moodle/mod/statements/view3.php?id=654&chapterid=2968
 * https://github.com/akueisara/algo-box/blob/master/week%205/primitive_calculator/PrimitiveCalculator.java
 */
public class M1 {

    public static void main(String[] args) {
        calculator1Test1();
    }

    private static void calculator1Test1() {
        List<Integer> r1 = new Calculator1().calc(5);
        for (int i : r1) {
            System.out.println(i);
        }
    }

    public static class Calculator1 {
        List<Integer> calc(int n) {
            List<Integer> sequence = new ArrayList<>();

            int[] a = new int[n + 1];
            a[1] = 0;

            int min;
            for (int i = 2; i < n + 1; i++) {
                min = a[i - 1] + 1;
                if (i % 2 == 0) min = Math.min(min, a[i / 2] + 1);
                if (i % 3 == 0) min = Math.min(min, a[i / 3] + 1);

                a[i] = min;
            }


            int i = n;
            while (i > 1) {
                if (a[i] == a[i - 1] + 1) {
                    sequence.add(1);
                    i--;
                    continue;
                }

                if (i % 2 == 0 && a[i] == a[i / 2] + 1) {
                    sequence.add(2);
                    i /= 2;
                    continue;
                }

                sequence.add(3);
                i /= 3;
            }

            Collections.reverse(sequence);
            return sequence;
        }
    }
}
