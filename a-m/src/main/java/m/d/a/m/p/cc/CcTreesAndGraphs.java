package m.d.a.m.p.cc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/
 */
public class CcTreesAndGraphs {
    public static void main(String[] args) {
        // TreesAndGraphs.DfsMaxDepth.run();
        // TreesAndGraphs.DfsMaxDepthIteratively.run();
        TreesAndGraphs.BfsPrintAllNodes.run();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair<T> {
        TreeNode node;
        T value;

        Pair(TreeNode node, T value) {
            this.node = node;
            this.value = value;
        }
    }

    static class TreesAndGraphs {
        static class DfsMaxDepth {
            static void run() {
                System.out.println("MaxDepth. " + maxDepth(createTreeNode()));
            }

            static int maxDepth(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                int maxLeft = maxDepth(root.left);
                int maxRight = maxDepth(root.right);
                return Math.max(maxLeft, maxRight) + 1;
            }
        }

        static class DfsMaxDepthIteratively {
            static void run() {
                System.out.println("MaxDepth. " + maxDepth(createTreeNode()));
            }

            static int maxDepth(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                Stack<Pair<Integer>> stack = new Stack<>();
                stack.push(new Pair<>(root, 1));
                int ans = 0;
                while (!stack.isEmpty()) {
                    Pair<Integer> currentPair = stack.pop();
                    TreeNode currentTreeNode = currentPair.node;
                    int currentDepth = currentPair.value;
                    ans = Math.max(ans, currentDepth);
                    if (currentTreeNode.left != null) {
                        stack.push(new Pair<>(currentTreeNode.left, currentDepth + 1));
                    }
                    if (currentTreeNode.right != null) {
                        stack.push(new Pair<>(currentTreeNode.right, currentDepth + 1));
                    }
                }
                return ans;
            }
        }

        static class BfsPrintAllNodes {
            static void run() {
                System.out.println("PrintAllNodes.");
                printAllNodes(createTreeNode());
                System.out.println();
            }

            static void printAllNodes(TreeNode root) {
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    int nodesInCurrentLevel = queue.size();
                    for (int i = 0; i < nodesInCurrentLevel; i++) {
                        TreeNode node = queue.remove();
                        System.out.print(node.val + ",");
                        if (node.left != null) {
                            queue.add(node.left);
                        }
                        if (node.right != null) {
                            queue.add(node.right);
                        }
                    }
                }
            }
        }

        static TreeNode createTreeNode() {
            TreeNode n0 = new TreeNode(0);
            TreeNode n1 = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            n0.left = n1;
            n0.right = n2;
            return n0;
        }
    }
}
