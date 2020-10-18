package m.d.a.m.p.algoprog.ru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p792 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        int c = 0;
        List<Character> result = new ArrayList<>();
        for (int i = a.length() - 1; i >= 0; i--) {
            result.add(a.charAt(i));
            if (c == 2) {
                c = 0;
                if (i != 0) {
                    result.add(',');
                }
            } else {
                c++;
            }
        }
        Collections.reverse(result);
        for (char v : result) {
            System.out.print(v);
        }
    }
}
