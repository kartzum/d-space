package m.d.a.m.p.lt.problems;

public class MergeTwoSortedLists {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n4;

        ListNode m1 = new ListNode(1);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);

        m1.next = m3;
        m3.next = m4;

        ListNode r = new Solution().mergeTwoLists(n1, m1);

        print(r);
    }

    static void print(ListNode n1) {
        ListNode current = n1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode n1 = l1;
            ListNode m1 = l2;
            ListNode r = new ListNode(0);
            ListNode current = r;
            while (n1 != null || m1 != null) {
                if (n1 != null) {
                    if (m1 != null) {
                        if (n1.val < m1.val) {
                            ListNode i = new ListNode(n1.val);
                            current.next = i;
                            current = i;
                            //System.out.println(n1.val);
                            n1 = n1.next;
                        } else {
                            ListNode i = new ListNode(m1.val);
                            current.next = i;
                            current = i;
                            //System.out.println(m1.val);
                            m1 = m1.next;
                        }
                    } else {
                        ListNode i = new ListNode(n1.val);
                        current.next = i;
                        current = i;
                        //System.out.println(n1.val);
                        n1 = n1.next;
                    }
                } else {
                    if (m1 != null) {
                        ListNode i = new ListNode(m1.val);
                        current.next = i;
                        current = i;
                        //System.out.println(m1.val);
                        m1 = m1.next;
                    }
                }
            }
            return r.next;
        }
    }
}
