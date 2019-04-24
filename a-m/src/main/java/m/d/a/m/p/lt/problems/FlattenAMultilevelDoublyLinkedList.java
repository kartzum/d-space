package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

    public static void main(final String[] args) {
        // test2();
        // test3();
        test1();
    }

    private static Node generate() {
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);

        Node node7 = new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node10 = new Node(10, null, null, null);

        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, null, null, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        node8.prev = node7;
        node9.prev = node8;
        node10.prev = node9;

        node11.next = node12;
        node12.prev = node11;

        node3.child = node7;

        node8.child = node11;

        return node1;
    }

    static void test2() {
        Node r = new Solution2().flatten(generate());
    }

    static void test3() {
        Node r = new Solution3().flatten(generate());
        Node current = r;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    static void test1() {
        Node r = new Solution1().flatten(generate());
        Node current = r;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    static class Solution1 {
        public Node flatten(Node head) {
            Stack<Node> stack = new Stack<>();
            Node cur = head;
            while (!stack.isEmpty() || cur != null) {
                if (cur.child != null) {
                    if (cur.next != null) stack.push(cur.next);
                    cur.next = cur.child;
                    cur.child.prev = cur;
                    cur.child = null;
                } else {
                    if (cur.next == null) {
                        if (!stack.isEmpty()) {
                            Node next = stack.pop();
                            next.prev = cur;
                            cur.next = next;
                        } else {
                            break;
                        }
                    }
                }
                cur = cur.next;
            }
            return head;
        }
    }

    static class Solution3 {
        public Node flatten(Node head) {
            tailflatten(null, head);
            return head;
        }

        Node tailflatten(Node prev, Node node) {
            if (node == null) return prev;

            node.prev = prev;
            Node next = node.next;
            Node child = node.child;
            node.child = null;

            node = tailflatten(node, node.next = child);
            node = tailflatten(node, node.next = next);
            return node;
        }
    }

    static class Solution2 {
        public Node flatten(Node head) {
            Stack<Node> s = new Stack<>();
            s.push(head);
            while (!s.isEmpty()) {
                Node n = s.pop();
                Node current = n;
                Node prev = null;
                while (current != null) {
                    System.out.println(current.val);
                    if (current.child != null) {
                        s.push(current.child);
                    }
                    prev = current;
                    current = current.next;
                }
                System.out.println("! " + n.val + ", " + prev.val);
            }
            return null;
        }
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;
}
