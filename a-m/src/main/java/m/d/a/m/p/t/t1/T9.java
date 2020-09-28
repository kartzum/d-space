package m.d.a.m.p.t.t1;

import java.util.*;
import java.util.stream.IntStream;

public class T9 {
    public static void main(String[] args) {
        // arrays();
        // collections();
        // maps();
        // stacks();
        // queues();
        myQueue();
    }

    static void arrays() {
        int[] a = new int[7];
        System.out.println(Arrays.toString(a));
        int[][] m = new int[3][5];
        for (int[] i : m) {
            System.out.println(Arrays.toString(i));
        }
        IntStream aStream = Arrays.stream(new int[]{1, 2, 3});
        aStream.map(i -> i * 2).forEach(System.out::println);
    }

    static void collections() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);
        System.out.println(Collections.max(collection));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Collections.reverse(list);
        Integer[] listAsArray = new Integer[list.size()];
        list.toArray(listAsArray);
        System.out.println(Arrays.toString(listAsArray));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.stream().forEach(System.out::println);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set.size());

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        System.out.println(treeSet.lower(2));
    }

    static void maps() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println(map.get(3));

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "5");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        SortedMap<Integer, String> sm = new TreeMap<>();
        sm.put(7, "7");
        sm.put(8, "8");
        sm.put(9, "9");
        for (Map.Entry<Integer, String> entry : sm.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    static void stacks() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static void queues() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    // Design Circular Queue.
    // https://leetcode.com/problems/design-circular-queue/

    static void myQueue() {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the queue is full
        int v = circularQueue.rear();  // return 3
        System.out.println(v);
    }

    // Entities.

    static class MyCircularQueue {
        int capacity;
        int[] queue;
        int count;
        int headIndex;

        MyCircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[this.capacity];
        }

        public boolean enQueue(int value) {
            if (count == capacity) {
                return false;
            }
            this.queue[(this.headIndex + this.count) % this.capacity] = value;
            this.count += 1;
            return true;
        }

        public boolean deQueue() {
            if (this.count == 0) {
                return false;
            }
            this.headIndex = (this.headIndex + 1) % this.capacity;
            this.count -= 1;
            return true;
        }

        public int front() {
            if (this.count == 0) {
                return -1;
            }
            return this.queue[this.headIndex];
        }

        public int rear() {
            if (this.count == 0) {
                return -1;
            }
            int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
            return this.queue[tailIndex];
        }
    }
}
