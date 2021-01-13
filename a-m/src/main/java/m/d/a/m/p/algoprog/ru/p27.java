// https://algoprog.ru/material/p27

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p27 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] temp = input.nextLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int c = a;
        int d = b;
        while (b != 0) {
            int t = (b + (a % b)) % b;
            a = b;
            b = t;
        }
        System.out.println(c / a + " " + d / a);
    }
}
