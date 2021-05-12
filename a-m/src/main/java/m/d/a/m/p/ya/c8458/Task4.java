package m.d.a.m.p.ya.c8458;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = 0;
        for (int i = 0; i < n; i++) {
            int v = input.nextInt();
            if (i == 0) {
                System.out.println(v);
            } else {
                if (p != v) {
                    System.out.println(v);
                }
            }
            p = v;
        }
    }
}
