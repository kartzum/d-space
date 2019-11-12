package m.d.a.m.p.lt.problems;

import java.util.ArrayList;

public class MiddleOfTheLinkedList {
    public static void main(final String[] args) {
        test1();
        // test2();
    }

    private static void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode r = new Solution1().middleNode(n1);
        System.out.println(r.val);
    }

    private static void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode r = new Solution2().middleNode(n1);
        System.out.println(r.val);
    }

    static class Solution1 {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    static class Solution2 {
        public ListNode middleNode(ListNode head) {
            ArrayList<ListNode> r = new ArrayList<>();
            ListNode current = head;
            while (current != null) {
                r.add(current);
                current = current.next;
            }
            ListNode n = r.get(r.size() / 2);
            return n;
        }
    }
}
