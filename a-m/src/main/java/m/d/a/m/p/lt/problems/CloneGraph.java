package m.d.a.m.p.lt.problems;

import java.util.*;

public class CloneGraph {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final Node node1 = new Node();
        node1.val = 1;
        node1.neighbors = new ArrayList<>();
        final Node node2 = new Node();
        node2.val = 2;
        node2.neighbors = new ArrayList<>();
        final Node node3 = new Node();
        node3.val = 3;
        node3.neighbors = new ArrayList<>();

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);

        final Node nodeR1 = new Solution().cloneGraph(node1);
        System.out.println(nodeR1.val);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        public Node cloneGraph(Node node) {
            final Stack<Node> stack = new Stack<>();
            stack.add(node);
            final Map<Node, Node> map = new HashMap<>();
            final Node n = new Node();
            n.val = node.val;
            n.neighbors = new ArrayList<>();
            map.put(node, n);
            while (!stack.isEmpty()) {
                final Node element = stack.pop();

                final List<Node> elements = element.neighbors;
                for (int i = 0; i < elements.size(); i++) {
                    final Node elementI = elements.get(i);

                    if (!map.containsKey(elementI)) {
                        final Node nn = new Node();
                        nn.val = elementI.val;
                        nn.neighbors = new ArrayList<>();
                        map.put(elementI, nn);
                        stack.push(elementI);
                    }
                    map.get(element).neighbors.add(map.get(elementI));
                }
            }
            return map.get(node);
        }
    }
}
