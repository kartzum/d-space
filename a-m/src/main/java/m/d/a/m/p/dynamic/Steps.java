package m.d.a.m.p.dynamic;

/**
 * https://foxford.ru/wiki/informatika/odnomernoe-dinamicheskoe-programmirovanie-kolichestvo-sposobov
 */
public class Steps {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(new Solution1().calc(4));
    }

    static class Solution1 {
        int calc(int n) {
            if (n < 2) {
                return 1;
            }
            return calc(n - 2) + calc(n - 1);
        }
    }
}
