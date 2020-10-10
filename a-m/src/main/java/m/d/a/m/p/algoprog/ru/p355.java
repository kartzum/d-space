// https://algoprog.ru/material/p355 - in progress.

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p355 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] values = input.nextLine().split(" ");
            for (int j = 0; j < values.length; j++) {
                m[i][j] = Integer.parseInt(values[j]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int a = m[j][i];
                int b = m[i][j];
                if (a != b) {
                    System.out.println("no");
                    return;
                }
            }
        }
        System.out.println("yes");
    }
}
