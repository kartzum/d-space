package m.d.a.m.p;

public class Lists {
    public static void main(String[] args) {
        //singlyLinkedListInit();
        singlyLinkedListFind();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void singlyLinkedListInit() {
        final ListNode head = new ListNode(1);
        singlyLinkedListFill(head);
        singlyLinkedListPrint(head);
    }

    private static void singlyLinkedListFind() {
        final ListNode head = new ListNode(1);
        singlyLinkedListFill(head);
        final ListNode listNode3 = singlyLinkedListFind(head, 3);
        singlyLinkedListAdd(listNode3, 7);
        System.out.println("'1'");
        System.out.println(listNode3.val);
        System.out.println("'2'");
        singlyLinkedListPrint(head);
        final ListNode listNode2 = singlyLinkedListFind(head, 2);
        singlyLinkedListRemove(listNode2);
        System.out.println("'3'");
        singlyLinkedListPrint(head);
    }

    private static void singlyLinkedListFill(final ListNode head) {
        ListNode current = head;
        for (int i = 1; i < 5; i++) {
            final ListNode next = new ListNode(i + 1);
            current.next = next;
            current = next;
        }
    }

    private static void singlyLinkedListPrint(final ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    private static ListNode singlyLinkedListFind(final ListNode head, final int val) {
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    private static void singlyLinkedListAdd(final ListNode node, final int val) {
        final ListNode newNode = new ListNode(val);
        final ListNode next = node.next;
        node.next = newNode;
        newNode.next = next;
    }

    private static void singlyLinkedListRemove(final ListNode node) {
        node.next = node.next.next;
    }
}
