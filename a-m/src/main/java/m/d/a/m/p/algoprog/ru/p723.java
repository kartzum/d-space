package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p723 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        a = a.substring(0, a.length() - 1);
        // String a = "Aabrrbaacda";
        char[] result = new char[a.length()];
        int l = 0;
        int r = a.length() - 1;
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0) {
                result[l] = a.charAt(i);
                l++;
            } else {
                result[r] = a.charAt(i);
                r--;
            }
        }
        for (char c : result) {
            System.out.print(c);
        }
    }
}
