package m.d.a.m.p.lt.problems;

public class PopulatingNextRightPointersInEachNode {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        Node root = new Node(0, null, null, null);
        System.out.println(new Solution().connect(root));
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node curr = root;
            while (curr != null && curr.left != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            // connect next level start from left most node
            connect(root.left);

            return root;
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
