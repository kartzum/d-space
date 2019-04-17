package m.d.a.m.p.lt.problems;

public class AddTwoNumbers {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        n2.next = n4;
        n4.next = n3;

        ListNode m5 = new ListNode(5);
        ListNode m6 = new ListNode(6);
        ListNode m4 = new ListNode(4);

        m5.next = m6;
        m6.next = m4;

        ListNode r = new Solution().addTwoNumbers(n2, m5);

        print(r);
    }

    private static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println();
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode r = new ListNode(0);
            ListNode n1 = l1;
            ListNode m1 = l2;
            ListNode current = r;
            int carry = 0;
            while (n1 != null || m1 != null) {
                int x = n1 != null ? n1.val : 0;
                int y = m1 != null ? m1.val : 0;
                int s = carry + x + y;
                carry = s / 10;
                current.next = new ListNode(s % 10);
                current = current.next;
                //System.out.println("x = " + x + ", y = " + y + ", carry = " + carry + ", s = " + s);
                if (n1 != null) {
                    n1 = n1.next;
                }
                if (m1 != null) {
                    m1 = m1.next;
                }
            }
            if (carry > 0) {
                current.next = new ListNode(carry);
            }
            return r.next;
        }
    }
}
