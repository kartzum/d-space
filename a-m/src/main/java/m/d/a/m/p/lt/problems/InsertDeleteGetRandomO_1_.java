package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandomO_1_ {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        RandomizedSet s = new RandomizedSet();
        s.insert(1);
        System.out.println(s.getRandom());
        s.remove(1);
    }

    static class RandomizedSet {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> al = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!hm.containsKey(val)) {
                al.add(val);
                hm.put(val, al.size() - 1);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (hm.size() == 0 || !hm.containsKey(val)) {
                return false;
            } else {
                int t = hm.get(val), l = al.size() - 1;
                if (t != l) {
                    int x = al.get(l);
                    al.set(t, x);
                    al.remove(l);
                    hm.replace(x, t);
                } else {
                    al.remove(t);
                }
                hm.remove(val);
                return true;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return al.get((int) (Math.random() * hm.size()));
        }
    }
}
