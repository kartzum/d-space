package m.d.a.m.p.coding;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Coding coding = new Coding();
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] f = {5, 9, 12, 13, 16, 45};
        Node root = coding.execute(chars, f);
        print(root, "");
    }

    private static class Node {
        int data;
        char c;
        Node left;
        Node right;
    }

    private static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node x, Node y) {
            return x.data - y.data;
        }
    }

    private static class Coding {
        Node execute(char[] chars, int[] f) {
            PriorityQueue<Node> q = new PriorityQueue<>(new NodeComparator());
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                Node node = new Node();
                node.data = f[i];
                node.c = chars[i];
                q.add(node);
            }
            Node root = null;
            while (q.size() > 1) {
                Node x = q.poll();
                Node y = q.poll();
                Node node = new Node();
                node.data = x.data + y.data;
                node.c = '-';
                node.left = x;
                node.right = y;
                root = node;
                q.add(node);
            }
            return root;
        }
    }

    private static void print(Node node, String s) {
        if (node.left == null && node.right == null && Character.isLetter(node.c)) {
            System.out.println(node.c + ":" + s);
            return;
        }
        print(node.left, s + "0");
        print(node.right, s + "1");
    }
}
