package m.d.a.m.p.lists;

public class DLists {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        final DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        System.out.println("-1-");
        list.trace();
        System.out.println("-1-");
        list.insert(list.head, 3);
        System.out.println("-2-");
        list.trace();
        System.out.println("-2-");
    }

    public static class DoublyLinkedList {
        Node head;

        class Node {
            int val;
            Node prev;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        void add(int val) {
            final Node newNode = new Node(val);

            newNode.next = head;
            newNode.prev = null;

            if (head != null) {
                head.prev = newNode;
            }

            head = newNode;
        }

        void insert(Node prevNode, int val) {
            if (prevNode == null) {
                return;
            }
            final Node newNode = new Node(val);

            newNode.next = prevNode.next;

            prevNode.next = newNode;

            newNode.prev = prevNode;

            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }

        void trace() {
            Node node = head;
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
}
