package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public static void main(final String[] args) {
        test();
    }

    static void test() {
        final List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(new ArrayList<>());
        rooms1.add(new ArrayList<>());
        rooms1.add(new ArrayList<>());
        rooms1.add(new ArrayList<>());
        rooms1.get(0).add(1);
        rooms1.get(1).add(2);
        rooms1.get(2).add(3);
        System.out.println(new Solution().canVisitAllRooms(rooms1));
    }

    public static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] seen = new boolean[rooms.size()];
            seen[0] = true;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            while (!stack.isEmpty()) {
                int node = stack.pop();
                for (int nei : rooms.get(node))
                    if (!seen[nei]) {
                        seen[nei] = true;
                        stack.push(nei);
                    }
            }

            for (boolean v : seen)
                if (!v) return false;
            return true;
        }
    }
}
