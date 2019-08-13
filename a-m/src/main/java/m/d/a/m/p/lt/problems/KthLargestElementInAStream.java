package m.d.a.m.p.lt.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(4));
    }

    static class KthLargest {
        private Queue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() == k + 1) {
                pq.remove();
            }
            return pq.peek();
        }
    }
}
