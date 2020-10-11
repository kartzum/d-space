// https://algoprog.ru/material/p71 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p71 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String values = input.nextLine();
        String[] nums = values.split(" ");

        String temp = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;

        for (String x : nums) {
            System.out.print(x + " ");
        }
    }
}
