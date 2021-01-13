// https://algoprog.ru/material/p915

package m.d.a.m.p.algoprog.ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p915 {
    public static void main(String[] args) throws IOException {
        run(args);
        // tests();
    }

    static void run(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] temp = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        System.out.println(calc(nums));
    }

    static void tests() {
        System.out.println(calc(new int[]{1, 3, 4, 5, 1}));
    }

    static int calc(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] table = new int[nums.length];
        table[0] = nums[0];
        table[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int m = Math.min(table[i - 1], table[i - 2]);
            int temp = nums[i];
            int v = m + temp;
            // System.out.printf("%d, %d, %d\n", m, temp, v);
            table[i] = v;
        }
        return table[nums.length - 1];
    }
}
