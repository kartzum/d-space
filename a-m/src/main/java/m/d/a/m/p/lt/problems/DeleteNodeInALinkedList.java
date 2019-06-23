package m.d.a.m.p.lt.problems;

public class DeleteNodeInALinkedList {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        new Solution().deleteNode(listNode2);
    }

    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
