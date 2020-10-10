// https://algoprog.ru/material/p64 - in progress.

// package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p64 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String values = input.nextLine();
        String[] nums = values.split(" ");
        for (int i = 0; i < nums.length; i++) {
            int v = Integer.parseInt(nums[i]);
            if (v % 2 == 0) {
                System.out.print(v + " ");
            }
        }
    }
}
