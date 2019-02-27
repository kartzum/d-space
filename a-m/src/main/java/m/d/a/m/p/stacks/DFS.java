package m.d.a.m.p.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        final Node node40 = new Node(40);
        final Node node20 = new Node(20);
        final Node node50 = new Node(50);
        final Node node70 = new Node(70);
        final Node node60 = new Node(60);
        final Node node30 = new Node(30);
        final Node node10 = new Node(10);

        node40.addNode(node10);
        node40.addNode(node20);
        node10.addNode(node30);
        node20.addNode(node10);
        node20.addNode(node30);
        node20.addNode(node60);
        node20.addNode(node50);
        node30.addNode(node60);
        node60.addNode(node70);
        node50.addNode(node70);

        dfs(node40);
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

    static void dfs(final Node node) {
        final Stack<Node> stack = new Stack<>();
        final List<Node> visited = new ArrayList<>();
        stack.add(node);
        visited.add(node);
        while (!stack.isEmpty()) {
            final Node element = stack.pop();

            System.out.println(element.data);

            final List<Node> elements = element.getNodes();
            for (int i = 0; i < elements.size(); i++) {
                final Node elementI = elements.get(i);
                if (!visited.contains(elementI)) {
                    stack.add(elementI);
                    visited.add(elementI);
                }
            }
        }
    }
}
