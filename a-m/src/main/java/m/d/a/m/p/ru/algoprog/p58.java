// https://algoprog.ru/material/p58

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p58 {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyQueue2 queue = new MyQueue2(200);
        while (true) {
            String command = reader.readLine();

            if ("exit".equals(command)) {
                System.out.println("bye");
                return;
            } else if (command.startsWith("push")) {
                String[] t = command.split(" ");
                long v = Long.parseLong(t[1]);
                queue.enQueue(v);
                System.out.println("ok");
            } else if ("pop".equals(command)) {
                if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    long v = queue.front();
                    queue.deQueue();
                    System.out.println(v);
                }
            } else if ("front".equals(command)) {
                if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    long v = queue.front();
                    System.out.println(v);
                }
            } else if ("size".equals(command)) {
                int s = queue.size();
                System.out.println(s);
            } else if ("clear".equals(command)) {
                queue.clear();
                System.out.println("ok");
            }
        }
    }

    static class MyQueue {
        long[] data;
        int front;
        int rear;
        int count;
        int s;

        MyQueue(int s) {
            this.s = s;
            this.data = new long[this.s];
            this.front = -1;
            this.rear = -1;
            this.count = 0;
        }

        boolean enQueue(long v) {
            if ((rear + 1) % data.length == front) {
                return false;
            }
            if (front == -1) {
                front = 0;
                rear = 0;
                data[rear] = v;
            } else {
                rear = (rear + 1) % data.length;
                data[rear] = v;
            }
            count++;
            return true;
        }

        boolean deQueue() {
            if (front == -1) return false;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % data.length;
            }
            count--;
            return true;
        }

        Long front() {
            if (isEmpty()) {
                return null;
            }
            return data[front];
        }

        boolean isEmpty() {
            return front == -1;
        }

        boolean isFull() {
            return (rear + 1) % data.length == front;
        }

        int size() {
            return count;
        }

        void clear() {
            this.front = -1;
            this.rear = -1;
            this.count = 0;
        }
    }

    static class MyQueue2 {
        long[] data;
        int first;
        int last;
        int s;

        MyQueue2(int s) {
            this.s = s;
            this.data = new long[s];
            this.first = 0;
            this.last = 0;
        }

        void enQueue(long v) {
            if (size() != s) {
                data[last] = v;
                last = (last + 1) % s;
            }
        }

        Long deQueue() {
            if (first == last) {
                return null;
            }
            long n = data[first];
            first = (first + 1) % s;
            return n;
        }

        Long front() {
            if (first == last) {
                return null;
            }
            return data[first];
        }

        boolean isEmpty() {
            return first == last;
        }

        int size() {
            if (first > last) {
                return s - first + last;
            } else {
                return last - first;
            }
        }

        void clear() {
            first = 0;
            last = 0;
        }
    }
}
