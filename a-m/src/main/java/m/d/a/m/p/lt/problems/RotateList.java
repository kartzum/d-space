package m.d.a.m.p.lt.problems;

public class RotateList {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        ListNode head = new ListNode(0);
        ListNode r = new Solution().rotateRight(head, 1);
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            if (k == 0) {
                return head;
            }

            ListNode faster = head;
            ListNode slower = head;
            int length = 1;

            while (faster.next != null) {
                faster = faster.next;
                length++;
            }

            for (int i = 1; i < (length - k % length); i++) {
                slower = slower.next;
            }

            faster.next = head;
            head = slower.next;
            slower.next = null;

            return head;
        }
    }
}
