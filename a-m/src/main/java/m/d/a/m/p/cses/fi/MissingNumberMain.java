package m.d.a.m.p.cses.fi;

public class MissingNumberMain {
    public static void main(String[] args) {
        boolean t = true;
        if (t) {
            test();
        } else {
            MissingNumberRun.run();
        }
    }

    static void test() {
        int[] nums = {0, 1, 1, 1, 0, 1};
        int v = MissingNumberRun.fun(nums);
        System.out.println(v);
    }
}
