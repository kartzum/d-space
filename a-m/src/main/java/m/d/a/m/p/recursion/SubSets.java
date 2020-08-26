package m.d.a.m.p.recursion;

import java.util.ArrayList;

public class SubSets {
    public static void main(String[] args) {
        run(3, 1, new ArrayList<>());
    }

    static void run(int n, int k, ArrayList<Integer> subset) {
        if (k == n + 1) {
            for (int v : subset) {
                System.out.print(v + ", ");
            }
            System.out.println();
        } else {
            subset.add(k);
            run(n, k + 1, subset);
            if (subset.size() > 0) {
                subset.remove(subset.size() - 1);
            }
            run(n, k + 1, subset);
        }
    }
}
