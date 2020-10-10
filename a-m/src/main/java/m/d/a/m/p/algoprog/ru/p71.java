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
        for (int i = nums.length - 2; i >= 0; i--) {
            String current = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = current;
        }
        nums[0] = temp;

        for (String x : nums) {
            System.out.print(x + " ");
        }
    }
}
