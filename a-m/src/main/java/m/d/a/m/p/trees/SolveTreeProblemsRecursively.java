package m.d.a.m.p.trees;

public class SolveTreeProblemsRecursively {
    public static void main(final String[] args) {
        // test1();
        test2();
    }

    static void test1() {
        final BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.add(6);
        binaryTreeNode.add(3);
        binaryTreeNode.add(7);
        System.out.println(new BinaryTreeNodeMaxDepthTopDown().maxDepth(binaryTreeNode.root));
    }

    static void test2() {
        final BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
        binaryTreeNode.add(6);
        binaryTreeNode.add(3);
        binaryTreeNode.add(7);
        System.out.println(new BinaryTreeNodeMaxDepthBottomUp().maxDepth(binaryTreeNode.root));
    }

    static class BinaryTreeNodeMaxDepthTopDown {
        int answer;

        int maxDepth(TreeNode root) {
            answer = 0;
            maxDepthInner(root, 1);
            return answer;
        }

        void maxDepthInner(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                answer = Math.max(answer, depth);
            }
            maxDepthInner(root.left, depth + 1);
            maxDepthInner(root.right, depth + 1);
        }
    }

    static class BinaryTreeNodeMaxDepthBottomUp {
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
