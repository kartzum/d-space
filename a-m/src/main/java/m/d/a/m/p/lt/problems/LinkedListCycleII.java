package m.d.a.m.p.lt.problems;

public class LinkedListCycleII {
    public static void main(final String[] args) {
        test1();
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

        System.out.println(new Solution().detectCycle(listNode3));
    }

    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    while (head != fast) {
                        fast = fast.next;
                        head = head.next;
                    }
                    return head;
                }
            }
            return null;
        }
    }
}
