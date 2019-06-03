package m.d.a.m.p.lt.problems;

import java.util.*;

public class GroupAnagrams {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> r = new Solution().groupAnagrams(s);
        for (List<String> l : r) {
            System.out.println(l);
        }
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> m = new HashMap<>();
            for (String s : strs) {
                char[] a_ = s.toCharArray();
                Arrays.sort(a_);
                String a = String.valueOf(a_);
                if (!m.containsKey(a)) {
                    List<String> l = new ArrayList<>();
                    l.add(s);
                    m.put(a, l);
                } else {
                    List<String> l = m.get(a);
                    l.add(s);
                }
            }
            List<List<String>> r = new ArrayList<>();
            for (Map.Entry<String, List<String>> e : m.entrySet()) {
                r.add(e.getValue());
            }
            return r;
        }
    }
}
