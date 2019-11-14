package m.d.a.m.p.lt.problems;

public class RemoveDuplicatesFromSortedList {
    public static void main(final String[] args) {
        test1();
        // test2();
    }

    private static void test1() {
        ListNode r = new Solution().deleteDuplicates(create1());
        print(r);
    }

    private static void test2() {
        ListNode r = new Solution().deleteDuplicates(create2());
        print(r);
    }

    private static ListNode create1() {
        ListNode n1 = new ListNode(1);
        ListNode n1_1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        n1.next = n1_1;
        n1_1.next = n2;
        return n1;
    }

    private static ListNode create2() {
        ListNode n1 = new ListNode(1);
        ListNode n1_1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n3_1 = new ListNode(3);
        n1.next = n1_1;
        n1_1.next = n2;
        n2.next = n3;
        n3.next = n3_1;
        return n1;
    }

    private static void print(ListNode n) {
        ListNode current = n;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.val == current.next.val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }
}
