package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p792 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int c = 0;
        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            result.insert(0, a.charAt(i));
            if (c == 2) {
                c = 0;
                if (i != 0) {
                    result.insert(0, ",");
                }
            } else {
                c++;
            }
        }
        System.out.print(result.toString());
    }
}
