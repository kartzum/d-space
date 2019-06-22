package m.d.a.m.p.lt.problems;

public class PopulatingNextRightPointersInEachNodeII {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        Node root = new Node(0, null, null, null);
        System.out.println(new Solution().connect(root));
    }

    static class Solution {
        public Node connect(Node root) {
            helper(root);
            return root;
        }

        private void helper(Node root) {
            if (root == null) return;
            Node tmpNode = new Node();
            Node curNode = tmpNode;
            while (root != null) {
                if (root.left != null) {
                    curNode.next = root.left;
                    curNode = curNode.next;
                }
                if (root.right != null) {
                    curNode.next = root.right;
                    curNode = curNode.next;
                }
                root = root.next;
            }
            helper(tmpNode.next);
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
