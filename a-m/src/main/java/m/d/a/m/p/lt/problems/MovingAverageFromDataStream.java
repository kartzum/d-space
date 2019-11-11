package m.d.a.m.p.lt.problems;

public class MovingAverageFromDataStream {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

    static class MovingAverage {
        private int[] b;
        private int k;
        private int s;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            b = new int[size];
        }

        public double next(int val) {
            if (s < b.length) {
                s++;
            }
            b[k % b.length] = val;
            k++;
            double r = 0;
            for (int i = 0; i < s; i++) {
                r += b[i];
            }
            return r / s;
        }
    }
}
