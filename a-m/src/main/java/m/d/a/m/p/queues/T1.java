package m.d.a.m.p.queues;

public class T1 {
    public static void main(String[] args) {
        final Queue q1 = new Queue(3);
        q1.enQueue(1);
        q1.enQueue(2);
        q1.enQueue(3);
        q1.enQueue(4);
        System.out.println(q1.getFront());
        System.out.println(q1.getRear());
        System.out.println(q1.isFull());
        System.out.println(q1.isEmpty());
        System.out.println(q1.getFront());
        q1.deQueue();
        System.out.println(q1.getFront());
        q1.deQueue();
        System.out.println(q1.getFront());
        q1.deQueue();
        System.out.println(q1.getFront());
        q1.deQueue();
        System.out.println(q1.getFront());
    }

    static class Queue {
        int front;
        int rear;
        int[] data;
        int s;

        Queue(int n) {
            data = new int[n];
            front = -1;
            rear = -1;
        }

        boolean enQueue(int n) {
            if ((rear + 1) % data.length == front) return false;
            if (rear == -1) {
                rear = 0;
                front = 0;
                data[rear] = n;
            } else {
                rear = (rear + 1) % data.length;
                data[rear] = n;
            }
            s += 1;
            return true;
        }

        boolean deQueue() {
            if (front == -1) return false;
            if (front == rear) {
                front = -1;
                rear = -1;
                System.out.println("deQueue!");
            } else {
                front = (front + 1) % data.length;
            }
            s -= 1;
            return true;
        }

        boolean isFull() {
            return s == data.length;
        }

        boolean isEmpty() {
            return front == -1;
        }

        int getFront() {
            if (isEmpty()) return -1;
            return data[front];
        }

        int getRear() {
            if (isEmpty()) return -1;
            return data[rear];
        }
    }
}
