package m.d.a.m.p.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        final Node node0 = new Node(0);
        final Node node1 = new Node(1);
        final Node node2 = new Node(2);
        final Node node3 = new Node(3);

        node0.addNode(node1);
        node0.addNode(node2);
        node1.addNode(node3);
        node2.addNode(node3);

        System.out.println(bfs(node0, node3));
    }

    static class Node {
        int data;
        List<Node> nodes;

        Node(int data) {
            this.data = data;
            this.nodes = new ArrayList<>();
        }

        void addNode(Node node) {
            nodes.add(node);
        }

        List<Node> getNodes() {
            return nodes;
        }
    }

    static int bfs(Node root, Node target) {
        final LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                final Node current = queue.remove();
                if (target.data == current.data) return step;
                for (Node next : current.getNodes()) {
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
