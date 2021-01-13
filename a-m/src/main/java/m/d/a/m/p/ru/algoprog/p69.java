// https://algoprog.ru/material/p69

package m.d.a.m.p.ru.algoprog;

import java.util.Scanner;

public class p69 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String values = input.nextLine();
        String[] nums = values.split(" ");
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            String temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
