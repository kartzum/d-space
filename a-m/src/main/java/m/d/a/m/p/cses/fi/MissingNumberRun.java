package m.d.a.m.p.cses.fi;

import java.util.Scanner;

public class MissingNumberRun {

    public static void main(String[] args) {
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt() - 1;
        int m = 1000000;
        int[] nums = new int[m];
        for (int i = 0; i < n; i++) {
            int v = input.nextInt();
            nums[v] = 1;
        }
        System.out.println(fun(nums));
    }

    static int fun(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return 0;
    }

}
