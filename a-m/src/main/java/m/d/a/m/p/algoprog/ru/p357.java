// https://algoprog.ru/material/p357

package m.d.a.m.p.algoprog.ru;

import java.util.Scanner;

public class p357 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] rc = input.nextLine().split(" ");
        int rows = Integer.parseInt(rc[0]);
        int columns = Integer.parseInt(rc[1]);
        int[][] matrix = new int[rows][columns];
        for (int j = 0; j < rows; j++) {
            String[] values = input.nextLine().split(" ");
            for (int i = 0; i < columns; i++) {
                matrix[j][i] = Integer.parseInt(values[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        int r = -1;
        int c = -1;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                int value = matrix[j][i];
                if (value > max) {
                    max = value;
                    r = j;
                    c = i;
                }
            }
        }
        System.out.println(max);
        System.out.println(r + " " + c);
    }
}
