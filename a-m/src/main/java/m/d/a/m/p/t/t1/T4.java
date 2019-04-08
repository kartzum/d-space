package m.d.a.m.p.t.t1;

public class T4 {
    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode_4 = new ListNode(-4);

        listNode3.next = listNode2;
        listNode2.next = listNode0;
        listNode0.next = listNode_4;

        listNode_4.next = listNode2;

        System.out.println(hasCycle(listNode3));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (s != f) {
            if (f == null || f.next == null) {
                return false;
            }
            s = s.next;
            f = f.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
