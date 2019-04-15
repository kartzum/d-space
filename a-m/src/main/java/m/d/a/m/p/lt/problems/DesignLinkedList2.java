package m.d.a.m.p.lt.problems;

public class DesignLinkedList2 {
    public static void main(final String[] args) {
        test1();
    }

    static void test1() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.print();
    }

    static class MyLinkedList2 {
        private class Node {
            int val;
            Node next;
            Node prev;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList2() {
            head = null;
            tail = null;
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getNode(index).val;
        }

        private Node getNode(int index) {
            Node current = head;
            while (index != 0) {
                current = current.next;
                index--;
            }
            return current;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node n = new Node(val);
            if (head == null) {
                head = n;
                tail = n;
                size++;
                return;
            }
            n.next = head;
            head.prev = n;
            head = n;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node n = new Node(val);
            if (tail == null) {
                head = n;
                tail = n;
                size++;
                return;
            }
            n.prev = tail;
            tail.next = n;
            tail = n;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node current = getNode(index);
                Node n = new Node(val);
                Node cPrev = current.prev;
                n.next = current;
                n.prev = cPrev;
                current.prev = n;
                cPrev.next = n;
                size++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
            } else if (index == size - 1) {
                tail = tail.prev;
            } else {
                Node current = getNode(index);
                Node cPrev = current.prev;
                Node cNext = current.next;
                cPrev.next = cNext;
                cNext.prev = cPrev;
            }
            size--;
        }

        void print() {
            Node current = head;
            while (current != null) {
                System.out.println(current.val);
                current = current.next;
            }
        }
    }
}
