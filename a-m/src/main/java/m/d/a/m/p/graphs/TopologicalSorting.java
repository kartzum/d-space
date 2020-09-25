package m.d.a.m.p.graphs;

import java.util.LinkedList;
import java.util.Stack;

// https://www.geeksforgeeks.org/java-program-for-topological-sorting/

public class TopologicalSorting {
    public static void main(String[] args) {
        test();
    }

    static void test() {

        //       [5]   [4]
        //      /  \   /  \
        //    [2]  [0]    [1]
        //    \         /
        //    [3]

        // 0 -> []
        // 1 -> []
        // 2 -> [3]
        // 3 -> [1]
        // 4 -> [0, 1]
        // 5 -> [2, 0]

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        Stack<Integer> r = topologicalSort(g);

        while (!r.empty()) {
            System.out.print(r.pop() + " ");
        }

        // 5 4 2 3 1 0
    }

    static Stack<Integer> topologicalSort(Graph graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.v];

        for (int i = 0; i < graph.v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        return stack;
    }

    static void topologicalSortUtil(Graph graph, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : graph.adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(graph, i, visited, stack);
        }
        stack.push(v);
    }

    static class Graph {
        private int v;
        private LinkedList<LinkedList<Integer>> adj;

        Graph(int v) {
            this.v = v;
            adj = new LinkedList<>();
            for (int i = 0; i < v; ++i)
                adj.add(new LinkedList<>());
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }
    }
}
