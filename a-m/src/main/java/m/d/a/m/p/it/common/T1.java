package m.d.a.m.p.it.common;

import java.util.*;

/**
 * Array (https://leetcode.com/tag/array/)
 * <p>
 * TwoSum
 * ContainerWithMostWater
 * MoveZeroes
 * MergeIntervals
 * <p>
 */
public class T1 {
    public static void main(String[] args) {
        runAll();
    }

    static void runAll() {
        List<T> tasks = new ArrayList<>();
        tasks.add(new TwoSum());
        tasks.add(new ContainerWithMostWater());
        tasks.add(new MoveZeroes());
        tasks.add(new MergeIntervals());
        tasks.add(new MaxCon());
        tasks.add(new AreAnagram());
        tasks.add(new PrintParenthesis());
        tasks.add(new ReverseList());
        tasks.add(new LongestOnes());
        tasks.add(new TopologicalSort());
        tasks.add(new IsBST());
        tasks.add(new DFS());
        tasks.add(new BFS());
        tasks.add(new EvalRPN());
        tasks.add(new AreParanthesisBalanced());
        for (T t : tasks) {
            t.tests();
        }
    }

    interface T {
        void tests();
    }

    /**
     * Two Sum.
     * https://leetcode.com/problems/two-sum/
     */
    static class TwoSum implements T {
        @Override
        public void tests() {
            int[] nums = new int[]{2, 7, 11, 15};
            int[] r = twoSum(nums, 9);
            System.out.println(Arrays.toString(r));
        }

        static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    /**
     * https://leetcode.com/problems/container-with-most-water/
     * https://leetcode.com/problems/container-with-most-water/discuss/6245/O(n)-Java-Solution-Two-Pointers
     */
    static class ContainerWithMostWater implements T {
        @Override
        public void tests() {
            System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        }

        public int maxArea(int[] height) {
            int maxWater = 0, left = 0, right = height.length - 1;
            while (left < right) {
                maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
                if (height[left] < height[right]) left++;
                else right--;
            }
            return maxWater;
        }
    }

    /**
     * Move Zeroes.
     * https://leetcode.com/problems/move-zeroes/
     */
    static class MoveZeroes implements T {
        @Override
        public void tests() {
            int[] nums = new int[]{1, 0, 3, 12};
            moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }

        static void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    k++;
                }
            }
        }
    }

    /**
     * https://leetcode.com/problems/merge-intervals/
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals, and return an array of the non-overlapping
     * intervals that cover all the intervals in the input.
     */
    static class MergeIntervals implements T {
        @Override
        public void tests() {
            int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
            int[][] r1 = new Solution().merge(intervals1);
            for (int[] x : r1) {
                System.out.print(x[0] + " " + x[1] + ", ");
            }
            // 1 6, 8 10, 15 18,
            System.out.println();
        }

        static class Solution {
            public int[][] merge(int[][] intervals) {
                Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
                LinkedList<int[]> merged = new LinkedList<>();
                for (int[] interval : intervals) {
                    // if the list of merged intervals is empty or if the current
                    // interval does not overlap with the previous, simply append it.
                    if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                        merged.add(interval);
                    }
                    // otherwise, there is overlap, so we merge the current and previous
                    // intervals.
                    else {
                        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                    }
                }
                return merged.toArray(new int[merged.size()][]);
            }
        }
    }

    /**
     * Maximum consecutive one’s (or zeros) in a binary array.
     * https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/
     */
    static class MaxCon implements T {
        public void tests() {
            System.out.println("2 = " + getMaxLength(new int[]{1, 1, 0, 1, 1, 0}));
            System.out.println("3 = " + getMaxLength(new int[]{1, 1, 0, 1, 1, 1}));
            System.out.println("3 = " + getMaxLength(new int[]{1, 1, 1}));
            System.out.println("0 = " + getMaxLength(new int[]{0, 0, 0}));
            System.out.println("0 = " + getMaxLength(new int[]{}));
        }

        static int getMaxLength(int arr[]) {
            int count = 0;
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    count = 0;
                } else {
                    count += 1;
                    result = Math.max(result, count);
                }
            }
            return result;
        }
    }

    /**
     * Check whether two strings are anagram of each other.
     * https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
     * https://www.baeldung.com/java-strings-anagrams
     */
    static class AreAnagram implements T {
        @Override
        public void tests() {
            System.out.println("true = " + areAnagram(("abc").toCharArray(), ("cba").toCharArray()));
            System.out.println("false = " + areAnagram(("sleep").toCharArray(), ("slep").toCharArray()));
        }

        static boolean areAnagram(char str1[], char str2[]) {
            if (str1.length != str2.length) {
                return false;
            }
            int m = 256;
            int[] count = new int[m];
            for (int i = 0; i < str1.length; i++) {
                count[str1[i]]++;
                count[str2[i]]--;
            }
            for (int i = 0; i < str1.length; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Print all combinations of balanced parentheses.
     * https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
     * https://leetcode.com/problems/generate-parentheses/
     */
    static class PrintParenthesis implements T {
        @Override
        public void tests() {
            List<String> r = generateParenthesis(3);
            System.out.println(Arrays.toString(r.toArray()));
        }

        static List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        static void backtrack(List<String> ans, String cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }
            if (open < max)
                backtrack(ans, cur + "(", open + 1, close, max);
            if (close < open)
                backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

    /**
     * Reverse Linked List.
     * https://leetcode.com/problems/reverse-linked-list/
     */
    static class ReverseList implements T {
        @Override
        public void tests() {
            ListNode n0 = new ListNode(0, null);
            ListNode n1 = new ListNode(1, null);
            ListNode n2 = new ListNode(2, null);
            n0.next = n1;
            n1.next = n2;
            ListNode r = reverseList(n0);
            print(r);
        }

        static ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode prev = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            return prev;
        }
    }

    /**
     * Max Consecutive Ones III.
     * https://leetcode.com/problems/max-consecutive-ones-iii/
     */
    static class LongestOnes implements T {
        @Override
        public void tests() {
            int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
            System.out.println(longestOnes(a, 2));
        }

        static int longestOnes(int[] A, int K) {
            int left = 0;
            int right = 0;
            for (right = 0; right < A.length; right++) {
                if (A[right] == 0) {
                    K--;
                }
                if (K < 0) {
                    if (A[left] == 0) {
                        K++;
                    }
                    left++;
                }
            }
            return right - left;
        }
    }

    /**
     * Topological Sorting.
     * https://www.geeksforgeeks.org/java-program-for-topological-sorting/
     */
    static class TopologicalSort implements T {
        @Override
        public void tests() {
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
    }

    /**
     * To check if a binary tree is BST or not.
     * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
     */
    static class IsBST implements T {
        @Override
        public void tests() {
            System.out.println(isBST(isBSTCreate(), null, null));
            System.out.println(isBST(isBSTCreate2(), null, null));
        }

        static TreeNode isBSTCreate() {
            //     [4]
            //    /   |
            //   [2]  [5]
            //  /  |
            // [1] [3]

            TreeNode n3 = new TreeNode(3);
            TreeNode n2 = new TreeNode(2);
            TreeNode n5 = new TreeNode(5);
            TreeNode n1 = new TreeNode(1);
            TreeNode n4 = new TreeNode(4);
            n4.left = n2;
            n4.right = n5;
            n2.left = n1;
            n2.right = n3;
            return n4;
        }

        static TreeNode isBSTCreate2() {
            //     [3]
            //    /   |
            //   [2]  [5]
            //  /  |
            // [1] [4]

            TreeNode n3 = new TreeNode(3);
            TreeNode n2 = new TreeNode(2);
            TreeNode n5 = new TreeNode(5);
            TreeNode n1 = new TreeNode(1);
            TreeNode n4 = new TreeNode(4);
            n3.left = n2;
            n3.right = n5;
            n2.left = n1;
            n2.right = n4;
            return n3;
        }

        static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
            if (root == null) return true;
            if (l != null && root.val <= l.val) return false;
            if (r != null && root.val >= r.val) return false;
            return isBST(root.left, l, root) && isBST(root.right, root, r);
        }
    }

    /**
     * DFS.
     * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
     * https://www.programiz.com/dsa/graph-dfs
     */
    static class DFS implements T {
        @Override
        public void tests() {
            //    [0]
            //   /  \
            // [1]  [2]
            //        \
            //        [3]

            Node n0 = new Node(0);
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            n0.nodes.add(n1);
            n0.nodes.add(n2);
            n2.nodes.add(n3);
            DFS(n0);
        }

        static void DFS(Node node) {
            Stack<Node> stack = new Stack<>();
            List<Node> visited = new LinkedList<>();
            stack.push(node);
            visited.add(node);
            while (!stack.isEmpty()) {
                Node currentNode = stack.pop();
                System.out.println(currentNode.val);
                for (Node childNode : currentNode.nodes) {
                    if (!visited.contains(childNode)) {
                        stack.push(childNode);
                        visited.add(childNode);
                    }
                }
            }
        }
    }

    /**
     * BFS.
     * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     */
    static class BFS implements T {
        @Override
        public void tests() {
            //    [0]
            //   /  \
            // [1]  [2]
            //        \
            //        [3]

            Node n0 = new Node(0);
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            n0.nodes.add(n1);
            n0.nodes.add(n2);
            n2.nodes.add(n3);
            BFS(n0);
        }

        static void BFS(Node node) {
            LinkedList<Node> queue = new LinkedList<>();
            List<Node> visited = new LinkedList<>();
            queue.add(node);
            visited.add(node);
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                System.out.println(currentNode.val);
                for (Node childNode : currentNode.nodes) {
                    if (!visited.contains(childNode)) {
                        queue.add(childNode);
                        visited.add(childNode);
                    }
                }
            }
        }
    }

    /**
     * Evaluate Reverse Polish Notation.
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     */
    static class EvalRPN implements T {
        @Override
        public void tests() {
            String[] tokens = new String[]{"2", "1", "+", "3", "*"};
            System.out.println(evalRPN(tokens));
        }

        static int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (!"+-*/".contains(token)) {
                    int v = Integer.parseInt(token);
                    stack.push(v);
                    continue;
                }
                int n2 = stack.pop();
                int n1 = stack.pop();
                int r = 0;
                switch (token) {
                    case "+":
                        r = n1 + n2;
                        break;
                    case "-":
                        r = n1 - n2;
                        break;
                    case "*":
                        r = n1 * n2;
                        break;
                    case "/":
                        r = n1 / n2;
                        break;
                }
                stack.push(r);
            }
            return stack.pop();
        }
    }

    /**
     * Check for balanced parentheses in an expression.
     * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
     */
    static class AreParanthesisBalanced implements T {
        @Override
        public void tests() {
            System.out.println(areParanthesisBalanced("([{}])"));
        }

        static boolean areParanthesisBalanced(String expr) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < expr.length(); i++) {
                char x = expr.charAt(i);
                if (x == '(' || x == '{' || x == '[') {
                    stack.push(x);
                    continue;
                }
                if (stack.isEmpty()) return false;
                switch (x) {
                    case ')':
                        stack.pop();
                        if (x == '{' || x == '[') {
                            return false;
                        }
                        break;
                    case '}':
                        stack.pop();
                        if (x == '(' || x == '[') {
                            return false;
                        }
                        break;
                    case ']':
                        stack.pop();
                        if (x == '{' || x == '(') {
                            return false;
                        }
                        break;
                }
            }
            return (stack.isEmpty());
        }
    }

    // Three and others.

    static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Node {
        List<Node> nodes;
        int val;

        Node(int val) {
            this.val = val;
            nodes = new LinkedList<>();
        }
    }
}
