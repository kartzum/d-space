package m.d.a.m.p.lt.problems;

import java.util.Arrays;

public class DesignHashSet {
    public static void main(final String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(10);
        System.out.println(set.contains(10));
        System.out.println(set.contains(11));
        set.remove(10);
        System.out.println(set.contains(10));
        System.out.println(set.contains(11));
    }

    public static class MyHashSet {
        private int[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            data = new int[1000001];
            Arrays.fill(data, -1);
        }

        public void add(int key) {
            data[key] = key;
        }

        public void remove(int key) {
            data[key] = -1;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return data[key] != -1;
        }
    }

}
