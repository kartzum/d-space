package m.d.a.m.p.lt.problems;

public class IntersectionOfTwoLinkedLists {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        ListNode a4 = new ListNode(4);
        ListNode a1 = new ListNode(1);
        ListNode a8 = new ListNode(8);
        ListNode a4_ = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a4.next = a1;
        a1.next = a8;
        a8.next = a4_;
        a4_.next = a5;

        ListNode b5 = new ListNode(5);
        ListNode b0 = new ListNode(0);
        ListNode b1 = new ListNode(1);
        ListNode b8 = new ListNode(8);
        ListNode b4 = new ListNode(4);
        ListNode b5_ = new ListNode(5);

        b5.next = b0;
        b0.next = b1;
        b1.next = b8;
        b8.next = b4;
        b4.next = b5_;

        System.out.println(new Solution().getIntersectionNode(a4, b5));
    }

    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = 0, lenB = 0;
            ListNode currA = headA, currB = headB;
            while (currA != null) {
                lenA++;
                currA = currA.next;
            }
            while (currB != null) {
                lenB++;
                currB = currB.next;
            }
            currA = headA;
            currB = headB;
            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; i++)
                    currA = currA.next;
            } else {
                for (int i = 0; i < lenB - lenA; i++)
                    currB = currB.next;
            }
            while (currA != currB) {
                currA = currA.next;
                currB = currB.next;
            }
            return currA;
        }
    }
}
