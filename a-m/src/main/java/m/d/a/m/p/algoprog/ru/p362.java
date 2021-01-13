// https://algoprog.ru/material/p362

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p362 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] nm = input.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] matrix = new int[n][m];
        for (int k = 0; k < n; k++) {
            matrix[k][0] = 1;
        }
        for (int k = 0; k < m; k++) {
            matrix[0][k] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                matrix[j][i] = matrix[j - 1][i] + matrix[j][i - 1];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                System.out.print(matrix[j][i] + "\t");
            }
            System.out.println();
        }
    }
}
