// https://algoprog.ru/material/p109

package m.d.a.m.p.ru.algoprog;

import java.util.HashSet;
import java.util.Scanner;

public class p109 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (set.contains(c)) {
                System.out.println(c);
                break;
            }
            set.add(c);
        }
    }
}
