package m.d.a.m.p.lt.problems;

public class CopyListWithRandomPointer {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        Node head = new Node(0, null, null);
        Node r = new Solution().copyRandomList(head);
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Node iter = head, next;

            // First round: make copy of each node,
            // and link them together side-by-side in a single list.
            while (iter != null) {
                next = iter.next;

                Node copy = new Node(iter.val, null, null);
                iter.next = copy;
                copy.next = next;

                iter = next;
            }

            // Second round: assign random pointers for the copy nodes.
            iter = head;
            while (iter != null) {
                if (iter.random != null) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }

            // Third round: restore the original list, and extract the copy list.
            iter = head;
            Node pseudoHead = new Node(0, null, null);
            Node copy, copyIter = pseudoHead;

            while (iter != null) {
                next = iter.next.next;

                // extract the copy
                copy = iter.next;
                copyIter.next = copy;
                copyIter = copy;

                // restore the original list
                iter.next = next;

                iter = next;
            }

            return pseudoHead.next;
        }
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
