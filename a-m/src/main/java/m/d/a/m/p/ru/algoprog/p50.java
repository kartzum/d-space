// https://algoprog.ru/material/p50

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class p50 {
    public static void main(String[] args) throws IOException {
        run();
        // tests();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] t1 = reader.readLine().split(" ");
        String[] t2 = reader.readLine().split(" ");
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            first.add(Integer.parseInt(t1[i]));
            second.add(Integer.parseInt(t2[i]));
        }
        calc(first, second);
    }

    static void tests() {
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();
        calc(first, second);
    }

    static void calc(LinkedList<Integer> first, LinkedList<Integer> second) {
        int n = 0;
        boolean finish = false;
        while (!first.isEmpty() && !second.isEmpty()) {
            n++;
            int a = first.remove();
            int b = second.remove();
            if ((a > b && a != 9) || (a == 9 && b != 0) || (a == 0 && b == 9)) {
                first.add(a);
                first.add(b);
            } else {
                second.add(a);
                second.add(b);
            }
            if (n == 1000000) {
                finish = true;
                break;
            }
        }
        if (finish) {
            System.out.println("botva");
        } else {
            if (first.size() != 0) {
                System.out.println("first" + " " + n);
            } else {
                System.out.println("second" + " " + n);
            }
        }
    }
}
