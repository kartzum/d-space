package m.d.a.m.p.lt.problems;

import java.util.Stack;

public class MinStackSolution {
    public static void main(final String[] args) {
        //test1();
        test2();
    }

    static void test1() {
        final MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.top());
    }

    static void test2() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println((minStack.getMin()));
    }

    static class MinStack {

        Stack<Integer> stack;

        int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            min = Math.min(min, x);
            stack.add(x);
            stack.add(min);
        }

        public void pop() {
            stack.pop();
            stack.pop();
            min = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
        }

        public int top() {
            final int t = stack.pop();
            final int r = stack.peek();
            stack.push(t);
            return r;
        }

        public int getMin() {
            return stack.peek();
        }
    }
}
