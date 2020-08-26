package m.d.a.m.p.cses.fi;

import java.util.ArrayList;
import java.util.Scanner;

public class WeirdAlgorithmRun {
    public static void main(String[] args) {
        boolean t = false;
        if (t) {
            test();
        } else {
            run();
        }
    }

    private static void test() {
        ArrayList<Long> r = new Solution().run(3);
        String t = toString(r);
        System.out.println(t);
    }

    private static void run() {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        ArrayList<Long> r = new Solution().run(n);
        String t = toString(r);
        System.out.println(t);
    }

    private static String toString(ArrayList<Long> r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.size(); i++) {
            long v = r.get(i);
            if (i < r.size() - 1) {
                sb.append(v);
                sb.append(" ");
            } else {
                sb.append(v);
            }
        }
        return sb.toString();
    }

    public static class Solution {
        public ArrayList<Long> run(long n) {
            ArrayList<Long> result = new ArrayList<>();
            result.add(n);
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                    result.add(n);
                } else {
                    n = n * 3 + 1;
                    result.add(n);
                }
            }

            return result;
        }
    }
}
