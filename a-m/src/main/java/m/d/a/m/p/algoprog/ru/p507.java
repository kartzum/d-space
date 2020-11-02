// https://algoprog.ru/material/p507 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p507 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] t = input.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(t[i]);
        }
        int j;
        for (j = 0; j < n - 1; j += 1) {
            boolean flag = true;
            for (int i = j; i < (n + i) / 2; i += 1) {
                if (nums[i] != nums[n - i + j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(j);
        for (int i = j; i > 0; i -= 1) {
            System.out.print(nums[i - 1] + " ");
        }
    }
}
