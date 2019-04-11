package m.d.a.m.p.lt.problems;

public class OddEvenLinkedList {
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

        ListNode r = new Solution().oddEvenList(n1);

        ListNode current = r;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode head1 = new ListNode(0);
            ListNode head2 = new ListNode(0);
            ListNode node1 = head1;
            ListNode node2 = head2;
            ListNode current = head;
            int i = 1;
            while (current != null) {
                if (i % 2 == 0) {
                    node2.next = current;
                    node2 = current;
                    System.out.println("2: " + current.val);
                } else {
                    node1.next = current;
                    node1 = current;
                    System.out.println("1: " + current.val);
                }
                ListNode temp = current.next;
                current.next = null;
                current = temp;
                i++;
            }
            ListNode result = head1.next;
            node1.next = head2.next;
            return result;
        }
    }
}
