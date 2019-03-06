package m.d.a.m.p.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class MyQueueSolution {
    public static void main(final String[] args) {
        // test1();
        // test2();
        test3();
    }

    static void test1() {
        final LinkedList<Integer> queue = new LinkedList<>();
        final MyQueue myQueue = new MyQueue();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(Arrays.toString(stack.toArray()));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static void test2() {
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(Arrays.toString(stack.toArray()));

        final Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        System.out.println(Arrays.toString(stack2.toArray()));

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
    }

    static void test3() {
        final MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        myQueue.push(6);
        myQueue.push(7);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    public static class MyQueue {

        final Stack<Integer> stack = new Stack<>();
        final Stack<Integer> stack2 = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (!stack2.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack.push(stack2.pop());
                }
            }
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
            }
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
            }
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty() && stack2.empty();
        }
    }
}
