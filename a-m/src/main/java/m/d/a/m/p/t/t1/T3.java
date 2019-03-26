package m.d.a.m.p.t.t1;

public class T3 {
    public static void main(String[] args) {
        test();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void test() {
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
}
