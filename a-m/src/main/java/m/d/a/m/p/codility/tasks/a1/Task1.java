package m.d.a.m.p.codility.tasks.a1;

import java.math.BigInteger;

public class Task1 {
    public static void main(final String[] args) {
        tests();
    }

    public static int solution(int A, int B) {
        // write your code in Java SE 8
        BigInteger c = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B));
        String binary = c.toString(2);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            char ch = binary.charAt(i);
            if (ch == '1') {
                count += 1;
            }
        }
        return count;
    }

    static void tests() {
        // test1();
        test2();
    }

    static void test1() {
        int A = 100_000_000;
        int B = 100_000_000;
        long c = A * B;
        BigInteger c2 = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B));
        System.out.println(c2.toString(2));
    }

    static void test2() {
        System.out.println(solution(3, 7));
    }
}
