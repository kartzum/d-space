// https://algoprog.ru/material/p199

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p199 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] t = input.nextLine().split(" ");
        int a = Integer.parseInt(t[0]);
        int b = Integer.parseInt(t[1]);
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        System.out.println(a);
    }
}
