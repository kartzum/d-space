package m.d.a.m.p.hse.m1;

public class M3 {
    public static void main(String[] args) {
        System.out.print(steps(7));
    }

    private static int steps(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return steps(n - 1) + steps(n - 2);
    }
}
