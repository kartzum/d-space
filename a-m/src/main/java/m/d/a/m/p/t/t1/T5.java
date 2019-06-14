package m.d.a.m.p.t.t1;

public class T5 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Factorial().run(3));
        System.out.println(new Factorial().run(4));
    }

    static class Factorial {
        int run(int n) {
            return run_(n, 1);
        }

        int run_(int x, int result) {
            if (x == 0) {
                return result;
            }
            return run_(x - 1, result * x);
        }
    }
}
