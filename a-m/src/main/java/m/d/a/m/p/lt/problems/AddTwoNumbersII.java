package m.d.a.m.p.lt.problems;

public class AddTwoNumbersII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        ListNode n1_7 = new ListNode(7);
        ListNode n1_2 = new ListNode(2);
        ListNode n1_4 = new ListNode(4);
        ListNode n1_3 = new ListNode(3);

        ListNode n2_5 = new ListNode(5);
        ListNode n2_6 = new ListNode(6);
        ListNode n2_4 = new ListNode(4);

        n1_7.next = n1_2;
        n1_2.next = n1_4;
        n1_4.next = n1_3;

        n2_5.next = n2_6;
        n2_6.next = n2_4;

        ListNode r = new Solution().addTwoNumbers(n1_7, n2_5);

        ListNode next = r;
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode r = new ListNode(0);
            ListNode current = r;
            ListNode n1 = reverse(l1);
            ListNode n2 = reverse(l2);
            int t = 0;
            while (n1 != null || n2 != null) {
                int x = n1 != null ? n1.val : 0;
                int y = n2 != null ? n2.val : 0;
                int s = x + y + t;
                t = s / 10;
                ListNode n = new ListNode(s % 10);
                current.next = n;
                current = n;
                if (n1 != null) {
                    n1 = n1.next;
                }
                if (n2 != null) {
                    n2 = n2.next;
                }
            }
            if (t > 0) {
                current.next = new ListNode(t);
            }
            return reverse(r.next);
        }

        private ListNode reverse(ListNode n) {
            ListNode current = n;
            ListNode prev = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            return prev;
        }
    }
}
