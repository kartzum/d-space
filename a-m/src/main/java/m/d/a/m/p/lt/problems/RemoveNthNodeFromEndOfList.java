package m.d.a.m.p.lt.problems;

public class RemoveNthNodeFromEndOfList {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode r = new Solution().removeNthFromEnd(n1, 2);

        System.out.println(r);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = 0;
            ListNode first = head;
            while (first != null) {
                length++;
                first = first.next;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            length -= n;
            first = dummy;
            while (length > 0) {
                length--;
                first = first.next;
            }

            first.next = first.next.next;

            return dummy.next;
        }
    }
}
