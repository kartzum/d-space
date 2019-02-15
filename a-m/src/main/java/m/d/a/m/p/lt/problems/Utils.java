package m.d.a.m.p.lt.problems;

class Utils {
    static ListNode listNodeInit() {
        final ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 1; i < 6; i++) {
            final ListNode node = new ListNode(i + 1);
            current.next = node;
            current = node;
        }
        return head;
    }

    static void listNodePrint(final ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
