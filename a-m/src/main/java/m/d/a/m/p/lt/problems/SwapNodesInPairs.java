package m.d.a.m.p.lt.problems;

public class SwapNodesInPairs {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode r = new Solution().swapPairs(n1);
        System.out.println(r.val);
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) { return null; }
            if (head.next == null) { return head; }

            ListNode next = head.next;
            ListNode following = next.next;
            head.next = swapPairs(following);
            next.next = head;

            return next;
        }
    }
}
