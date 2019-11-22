package m.d.a.m.p.lt.problems;

import java.util.LinkedList;

public class ReorderList {

    public static void main(final String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        ListNode r1 = new Solution().reverseList(create());
        System.out.println(r1.val);
    }

    private static void test2() {
        ListNode r1 = create();
        new Solution().reorderList(r1);
        System.out.println(r1.val);
    }

    private static ListNode create() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        return n1;
    }

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null)
                return;
            ListNode slow = head, fast = head;
            LinkedList<ListNode> stk = new LinkedList<>();
            //Detect the cutting node by slow-fast-runner
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //Cut the list, push the second part into stack
            ListNode toInsert = slow.next;
            slow.next = null;
            while (toInsert != null) {
                stk.push(toInsert);
                toInsert = toInsert.next;
            }
            slow = head;
            fast = slow.next;
            //Insert nodes of second part into first part at every interval between two nodes.
            while (!stk.isEmpty()) {
                slow.next = stk.pop();
                slow.next.next = fast;
                slow = fast;
                fast = slow.next;
            }
        }

        public ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode prev = null;
            while (current != null) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
    }
}
