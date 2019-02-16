package m.d.a.m.p.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        queueTest();
    }

    private static void myCircularQueueTest() {
        final MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.isFull());
        queue.enQueue(4);
        System.out.println(queue.isFull());
        queue.deQueue();
        System.out.println(queue.isFull());
        int i = 0;
    }

    private static void myCircularQueueTest2() {
        final MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }

    private static void myCircularQueueTest3() {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.deQueue();
        int param_3 = obj.Front();
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
    }

    private static void queueTest() {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }

    static class MyCircularQueue {
        final int[] data;
        int front;
        int rear;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            data = new int[k];
            front = -1;
            rear = -1;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if ((rear + 1) % data.length == front) return false;
            if (front == -1) {
                front = 0;
                rear = 0;
                data[rear] = value;
            } else {
                rear = (rear + 1) % data.length;
                data[rear] = value;
            }
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (front == -1) return false;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % data.length;
            }
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) return -1;
            return data[front];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) return -1;
            return data[rear];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return front == -1;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (rear + 1) % data.length == front;
        }
    }
}
