// https://algoprog.ru/material/p54

// https://www.tutorialspoint.com/javaexamples/data_stack.htm

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p54 {

    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyStack myStack = new MyStack(100);
        while (true) {
            String command = reader.readLine();

            if ("exit".equals(command)) {
                System.out.println("bye");
                return;
            } else if (command.startsWith("push")) {
                String[] t = command.split(" ");
                long v = Long.parseLong(t[1]);
                myStack.push(v);
                System.out.println("ok");
            } else if ("pop".equals(command)) {
                long v = myStack.pop();
                System.out.println(v);
            } else if ("back".equals(command)) {
                long v = myStack.peek();
                System.out.println(v);
            } else if ("size".equals(command)) {
                int s = myStack.size();
                System.out.println(s);
            } else if ("clear".equals(command)) {
                myStack.clear();
                System.out.println("ok");
            }
        }
    }

    static class MyStack {
        long[] data;
        int top;
        int count;

        MyStack(int s) {
            this.data = new long[s];
            this.top = -1;
        }

        void push(long v) {
            data[++top] = v;
            count++;
        }

        long pop() {
            count--;
            return data[top--];
        }

        long peek() {
            return data[top];
        }

        int size() {
            return count;
        }

        void clear() {
            top = -1;
            count = 0;
        }
    }
}
