// https://algoprog.ru/material/p72

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p72 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String values = input.nextLine();
        String[] nums = values.split(" ");
        int max = Integer.MIN_VALUE;
        for (String num : nums) {
            int current = Integer.parseInt(num);
            if (current > max) {
                max = current;
            }
        }
        System.out.println(max);
    }
}
