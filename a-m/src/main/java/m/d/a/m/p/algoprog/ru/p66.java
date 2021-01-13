// https://algoprog.ru/material/p66

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p66 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String values = input.nextLine();
        String[] nums = values.split(" ");
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            int vCurrent = Integer.parseInt(nums[i]);
            int vPrev = Integer.parseInt(nums[i - 1]);
            if (vCurrent > vPrev) {
                k++;
            }
        }
        System.out.println(k);
    }
}
