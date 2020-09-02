package m.d.a.m.p.cses.fi;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.geeksforgeeks.org/split-numbers-from-1-to-n-into-two-equal-sum-subsets/

public class TwoSetsRun {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        Scanner input = new Scanner(System.in);
        int n = 260443; // input.nextInt();  // 7;
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        calc(n, v1, v2);
        if (v1.size() > 0 && v2.size() > 0) {
            int a = 0;
            for (int v : v1) {
                a += v;
            }
            int b = 0;
            for (int v : v2) {
                b += v;
            }
            if (a == b) {
                System.out.println("YES");
                print(v1);
                print(v2);
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }

    private static void print(ArrayList<Integer> v) {
        System.out.println(v.size());
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();
    }

    private static void calc(int n, ArrayList<Integer> v1, ArrayList<Integer> v2) {
        // Base case
        if (n <= 2) {
            return;
        }

        // Sum of first numbers upto N
        int value = (n * (n + 1)) / 2;

        // When N is even
        if ((n & 1) == 0) {
            int turn = 1;
            int start = 1;
            int last = n;
            while (start < last) {
                if (turn == 1) {
                    v1.add(start);
                    v1.add(last);
                    turn = 0;
                } else {
                    v2.add(start);
                    v2.add(last);
                    turn = 1;
                }

                // Increment start
                start++;

                // Decrement last
                last--;
            }
        }

        // When N is odd
        else {

            // Required sum of the subset
            int rem = value / 2;

            // Boolean array to keep
            // track of used elements
            boolean[] vis = new boolean[n + 1];

            for (int i = 1; i <= n; i++)
                vis[i] = false;

            vis[0] = true;

            // Iterate from N to 1
            for (int i = n; i >= 1; i--) {
                if (rem > i) {
                    v1.add(i);
                    vis[i] = true;
                    rem -= i;
                } else {
                    v1.add(rem);
                    vis[rem] = true;
                    break;
                }
            }

            // Assigning the unused
            // elements to second subset
            for (int i = 1; i <= n; i++) {
                if (!vis[i])
                    v2.add(i);
            }
        }

    }
}
