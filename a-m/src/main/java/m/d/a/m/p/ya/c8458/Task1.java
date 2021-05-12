package m.d.a.m.p.ya.c8458;

import java.util.HashSet;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String J = input.nextLine(); // "ab";
        String S = input.nextLine(); // "aabbccd";
        System.out.println(run(J, S));
    }

    static int run(String J, String S) {
        int counter = 0;
        if (S != null && J != null) {
            HashSet<Character> d = new HashSet<>();
            for (Character c : J.toCharArray()) {
                d.add(c);
            }
            for (Character c : S.toCharArray()) {
                if (d.contains(c)) {
                    counter += 1;
                }
            }
        }
        return counter;
    }
}
