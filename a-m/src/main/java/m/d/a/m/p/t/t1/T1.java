package m.d.a.m.p.t.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T1 {
    public static void main(String[] args) {
       // testPreOrder();
       // testInOrder();
       testPostOrder();
    }

    private static TreeNode data() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode5.left = treeNode6;
        return treeNode1;
    }

    private static void testPreOrder(){
        List<Integer> result = preOrder(data());
        System.out.println(result);
    }

    private static void testInOrder(){
        List<Integer> result = inOrder(data());
        System.out.println(result);
    }

    private static void testPostOrder(){
        List<Integer> result = postOrder(data());
        System.out.println(result);
    }

    private static List<Integer> preOrder(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            while (node != null) {
                l.add(node.val);
                s.push(node.right);
                node = node.left;
            }
        }
        return l;
    }

    private static List<Integer> inOrder(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            l.add(cur.val);
            cur = cur.right;
        }
        return l;
    }

    private static List<Integer> postOrder(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            l.add(0, node.val);
            if(node.left != null) {
                s.push(node.left);
            }
            if(node.right != null) {
                s.push(node.right);
            }
        }
        return l;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
