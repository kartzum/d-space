// https://algoprog.ru/material/p105

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p105 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String b = input.nextLine();
        if (a.equals(b)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
