package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(final String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode_4 = new ListNode(-4);

        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode_4;

        listNode_4.next = listNode2;

        System.out.println(new Solution().hasCycle(listNode3));
    }

    private static void test2() {
        ListNode listNode1 = new ListNode(1);
        System.out.println(new Solution().hasCycle(listNode1));
    }

    private static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println();
    }

    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

    static public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            // print(head);
            Set<ListNode> set = new HashSet<>();
            ListNode current = head;
            while (current != null) {
                if (set.contains(current)) {
                    return true;
                }
                set.add(current);
                current = current.next;
            }
            return false;
        }
    }
}
