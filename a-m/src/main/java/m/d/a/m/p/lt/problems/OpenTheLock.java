package m.d.a.m.p.lt.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class OpenTheLock {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final String[] deadends1 = new String[]{
                "0201", "0101", "0102", "1212", "2002"
        };
        final String target1 = "0202";
        System.out.println(new Solution().openLock(deadends1, target1));

        final String[] deadends2 = new String[]{
                "8888"
        };
        final String target2 = "0009";
        System.out.println(new Solution().openLock(deadends2, target2));

        final String[] deadends3 = new String[]{
                "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"
        };
        final String target3 = "8888";
        System.out.println(new Solution().openLock(deadends3, target3));

        final String[] deadends4 = new String[]{
                "0000"
        };
        final String target4 = "8888";
        System.out.println(new Solution().openLock(deadends4, target4));
    }

    static class Solution {
        public int openLock(String[] deadends, String target) {
            final String start = "0000";
            final LinkedList<String> queue = new LinkedList<>();
            final Set<String> visited = new HashSet<>();
            final Set<String> dSet = new HashSet<>(java.util.Arrays.asList(deadends));
            queue.add(start);
            int level = 0;

            while (!queue.isEmpty()) {
                final int s = queue.size();
                for (int i = 0; i < s; i++) {
                    final String v = queue.remove();
                    if (v.equals(target)) return level;
                    if (visited.contains(v)) continue;
                    if (dSet.contains(v)) continue;
                    visited.add(v);
                    final char[] elements = v.toCharArray();
                    for (int l = 0; l < elements.length; l++) {
                        final char t = elements[l];
                        if (elements[l] < '9') {
                            elements[l]++;
                        } else {
                            elements[l] = '0';
                        }
                        queue.add(new String(elements));
                        elements[l] = t;
                        if (elements[l] > '0') {
                            elements[l]--;
                        } else {
                            elements[l] = '9';
                        }
                        queue.add(new String(elements));
                        elements[l] = t;
                    }
                }
                level++;
            }
            return -1;
        }
    }
}
