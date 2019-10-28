package m.d.a.m.p.lt.problems;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        ListNode n1 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n4;
        n4.next = n5;
        ListNode n1_1 = new ListNode(1);
        ListNode n1_3 = new ListNode(3);
        ListNode n1_4 = new ListNode(4);
        n1_1.next = n1_3;
        n1_3.next = n1_4;
        ListNode n2_2 = new ListNode(2);
        ListNode n2_6 = new ListNode(6);
        n2_2.next = n2_6;

        ListNode r = new Solution().mergeKLists(new ListNode[]{n1, n1_1, n2_2});
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }
            PriorityQueue<ListNode> p = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode list : lists) {
                if (list != null) {
                    p.offer(list);
                }
            }
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (!p.isEmpty()) {
                ListNode t = p.poll();
                current.next = t;
                if(t.next != null) {
                    p.offer(t.next);
                }
                current = t;
            }
            return dummy.next;
        }
    }
}
