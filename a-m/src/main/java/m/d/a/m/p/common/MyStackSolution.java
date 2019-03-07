package m.d.a.m.p.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MyStackSolution {
    public static void main(final String[] args) {
        // test1();
        //test2();
        test3();
    }

    static void test1() {
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println(stack.peek());
    }

    static void test2() {
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println(stack.peek());

        final LinkedList<Integer> queue = new LinkedList<>();
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    static void test3() {
        final MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(Arrays.toString(myStack.queue.toArray()));
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    public static class MyStack {

        final LinkedList<Integer> queue = new LinkedList<>();
        final LinkedList<Integer> queue2 = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (!queue2.isEmpty()) {
                while (!queue2.isEmpty()) {
                    queue.add(queue2.pollLast());
                }
            }
            queue.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    queue2.add(queue.pollLast());
                }
            }
            return queue2.pop();
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    queue2.add(queue.pollLast());
                }
            }
            return queue2.getFirst();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty() && queue2.isEmpty();
        }
    }
}
