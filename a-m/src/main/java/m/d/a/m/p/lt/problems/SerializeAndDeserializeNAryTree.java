package m.d.a.m.p.lt.problems;

import java.util.*;

public class SerializeAndDeserializeNAryTree {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        String r = new Codec1().serialize(generate());
        System.out.println(r);

        Node d = new Codec1().deserialize(r);
        System.out.println(d);
    }

    private static void test2() {
        String r = new Codec2().serialize(generate());
        System.out.println(r);

        Node d = new Codec2().deserialize(r);
        System.out.println(d);
    }

    private static Node generate() {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.children.add(new Node(5, new ArrayList<>()));
        node3.children.add(new Node(6, new ArrayList<>()));

        return node1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Codec1 {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder b = new StringBuilder();
            serializeHelper(root, b);
            return b.toString();
        }

        private void serializeHelper(Node n, StringBuilder b) {
            if (n == null) {
                return;
            }
            b.append(n.val);
            if (n.children.size() > 0) {
                b.append(" [");
                for (Node node : n.children) {
                    serializeHelper(node, b.append(" "));
                }
                b.append(" ]");
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data == null || data.length() < 1) return null;
            String[] nodes = data.split(" ");
            Deque<Node> stack = new LinkedList<>();
            Node curr = new Node(Integer.valueOf(nodes[0]), new LinkedList<>()), parent = curr;

            for (int i = 1; i < nodes.length; i++) {
                if (nodes[i].equals("[")) {
                    stack.push(curr);
                } else if (nodes[i].equals("]")) {
                    parent = stack.pop();
                } else {
                    curr = new Node(Integer.valueOf(nodes[i]), new LinkedList<>());
                    stack.peek().children.add(curr);
                }
            }
            return parent;
        }
    }

    static class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(Node root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(",");
            } else {
                sb.append(root.val).append(",");
                sb.append(root.children.size()).append(",");
                for (Node child : root.children) {
                    serialize(child, sb);
                }
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q);
        }

        private Node deserialize(Queue<String> q) {
            String s = q.poll();
            if (s.equals("#")) return null;

            Node root = new Node(Integer.valueOf(s), new ArrayList<>());
            int children = Integer.valueOf(q.poll());

            root.children = new ArrayList<>();
            for (int i = 0; i < children; i++) {
                root.children.add(deserialize(q));
            }
            return root;
        }
    }
}
