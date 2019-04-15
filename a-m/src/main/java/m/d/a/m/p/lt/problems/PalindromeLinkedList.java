package m.d.a.m.p.lt.problems;

public class PalindromeLinkedList {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        System.out.println(new Solution().isPalindrome(n1));
    }

    private static void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n2_ = new ListNode(2);
        ListNode n1_ = new ListNode(1);
        n1.next = n2;
        n2.next = n2_;
        n2_.next = n1_;
        System.out.println(new Solution().isPalindrome(n1));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            ListNode fast = head, slow = head;

            /** find middle element */
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            /** when the length is odd */
            if (fast != null) slow = slow.next;

            /** reverse the second half */
            ListNode prev = null;
            while (slow != null) {
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }

            /** compare the first and second half */
            slow = prev;
            while (slow != null) {
                if (head.val != slow.val) return false;
                head = head.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
