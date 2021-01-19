// https://algoprog.ru/material/p1460

// https://hsecodes.com/index.php/tasksdecision/index/467
// https://www.geeksforgeeks.org/how-to-left-or-right-rotate-an-array-in-java/
// https://www.geeksforgeeks.org/print-left-rotation-array/
// https://leetcode.com/problems/rotate-array/

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1460 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nn = new int[n];
        String[] t = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nn[i] = Integer.parseInt(t[i]);
        }
        int k = Integer.parseInt(reader.readLine());
        calc(n, nn, k);
    }

    static void calc(int n, int[] nn, int k) {
        if (k > 0) {
            rRotate(n, nn, k);
        } else {
            lRotate(n, nn, k);
        }
    }

    static void rRotate(int n, int[] nn, int k) {
        k %= nn.length;
        reverse(nn, 0, nn.length - 1);
        reverse(nn, 0, k - 1);
        reverse(nn, k, nn.length - 1);
        /*for (int i = 0; i < n; i++) {
            System.out.print(nn[i] + " ");
        }*/
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            buffer.append(nn[i]);
            buffer.append(" ");
        }
        System.out.println(buffer.toString());
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void lRotate(int n, int[] nn, int k) {
        int kk = Math.abs(k);
        int mod = kk % n;
        /*for (int i = 0; i < n; ++i) {
            System.out.print(nn[(i + mod) % n] + " ");
        }*/
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            buffer.append(nn[(i + mod) % n]);
            buffer.append(" ");
        }
        System.out.println(buffer.toString());
    }

    static void calc2(int n, int[] nn, int k) {
        if (k > 0) {
            rightRotate(n, nn, k);
        } else {
            leftRotate(n, nn, k);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nn[i] + " ");
        }
    }

    static void rightRotate(int n, int[] nn, int k) {
        k = n - k;
        k = k % n;
        int i, j, k1, temp;
        int g_c_d = gcd(k, n);
        for (i = 0; i < g_c_d; i++) {
            temp = nn[i];
            j = i;
            while (true) {
                k1 = j + k;
                if (k1 >= n)
                    k1 = k1 - n;
                if (k1 == i)
                    break;
                nn[j] = nn[k1];
                j = k1;
            }
            nn[j] = temp;
        }
    }

    static void leftRotate(int n, int[] nn, int k) {
        k = k % n;
        int i, j, k1, temp;
        int g_c_d = gcd(k, n);
        for (i = 0; i < g_c_d; i++) {
            temp = nn[i];
            j = i;
            while (true) {
                k1 = j + k;
                if (k1 >= n)
                    k1 = k1 - n;
                if (k1 == i)
                    break;
                nn[j] = nn[k1];
                j = k1;
            }
            nn[j] = temp;
        }
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void calc1(int n, int[] nn, int k) {
        StringBuilder buffer = new StringBuilder();
        if (k > 0) {
            int kk = k;
            kk %= nn.length;
            for (int i = nn.length - kk; i < nn.length; ++i) {
                buffer.append(nn[i]);
                buffer.append(" ");
            }
            for (int i = 0; i < nn.length - kk; ++i) {
                buffer.append(nn[i]);
                buffer.append(" ");
            }
        } else {
            int kk = Math.abs(k);
            kk %= nn.length;
            for (int i = kk; i < nn.length; ++i) {
                buffer.append(nn[i]);
                buffer.append(" ");
            }
            for (int i = 0; i < kk; ++i) {
                buffer.append(nn[i]);
                buffer.append(" ");
            }
        }
        System.out.println(buffer.toString());
    }
}
