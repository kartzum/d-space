// https://algoprog.ru/material/p63

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p63 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String values = input.nextLine();
        String[] nums = values.split(" ");
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
