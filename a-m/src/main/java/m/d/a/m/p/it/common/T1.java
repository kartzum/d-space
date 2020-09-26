package m.d.a.m.p.it.common;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        // maxConTest();
        // areAnagramTest();
        // printParenthesisTest();
        // reverseListTest();
        // longestOnesTest();
        // moveZeroesTest();
        // twoSumTest();
        // topologicalSortTest();
        // isBSTTest();
        DFSTest();
    }

    // Maximum consecutive one’s (or zeros) in a binary array.
    // https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/

    static void maxConTest() {
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

    // Check whether two strings are anagram of each other.
    // https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
    // https://www.baeldung.com/java-strings-anagrams

    static void areAnagramTest() {
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

    // Print all combinations of balanced parentheses.
    // https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
    // https://leetcode.com/problems/generate-parentheses/

    static void printParenthesisTest() {
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

    // Reverse Linked List.
    // https://leetcode.com/problems/reverse-linked-list/

    static void reverseListTest() {
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

    // Max Consecutive Ones III.
    // https://leetcode.com/problems/max-consecutive-ones-iii/

    static void longestOnesTest() {
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

    // Move Zeroes.
    // https://leetcode.com/problems/move-zeroes/

    static void moveZeroesTest() {
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

    // Two Sum.
    // https://leetcode.com/problems/two-sum/

    static void twoSumTest() {
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

    // Topological Sorting.
    // https://www.geeksforgeeks.org/java-program-for-topological-sorting/

    static void topologicalSortTest() {
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

    // To check if a binary tree is BST or not.
    // https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

    static void isBSTTest() {
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

    // DFS.
    // https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
    // https://www.programiz.com/dsa/graph-dfs

    static void DFSTest() {
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
