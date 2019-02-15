package m.d.a.m.p.lt.problems;

public class RemoveLinkedListElements {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final ListNode head = new ListNode(1);
        final int[] values = new int[]{2, 6, 3, 4, 5, 6};
        ListNode current = head;
        for (int value : values) {
            final ListNode node = new ListNode(value);
            current.next = node;
            current = node;
        }
        System.out.println("head");
        Utils.listNodePrint(head);
        final ListNode result = new Solution().removeElements(head, 6);
        System.out.println("result");
        Utils.listNodePrint(result);
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            while (head != null && head.val == val) {
                head = head.next;
            }
            ListNode current = head;
            ListNode prev = head;
            while (current != null) {
                if (current.val == val) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }
            return head;
        }
    }
}
