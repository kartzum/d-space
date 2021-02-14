package m.d.a.m.p.ya.c21631;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TaskJ2 {
    public static void main(String[] args) throws IOException, ParseException {
        tests();
        // run();
    }

    static void run() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            String data1 = r.readLine();
            String data2 = r.readLine();
            calcAndPrint(data1, data2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void tests() throws IOException {
        /*test1();
        test2();
        test3();*/
        test4();
    }

    static void test1() throws IOException {
        String data1 = readFromFile("./data/ya/c21631/J2/j1.json");
        String data2 = readFromFile("./data/ya/c21631/J2/j2.json");
        calcAndPrint(data1, data2);
    }

    static void test2() {
        String data1 = "\"just text\"";
        String data2 = "\"just text\"";
        calcAndPrint(data1, data2);
    }

    static void test3() {
        String data1 = "\"1.0e+10\"";
        String data2 = "\"null\"";
        calcAndPrint(data1, data2);
    }

    static void test4() {
        /*calcAndPrint(null, null);
        calcAndPrint("", null);
        calcAndPrint(null, "");
        calcAndPrint("", "");*/
        calcAndPrint("null1", "null1");
    }

    static void calcAndPrint(String data1, String data2) {
        JSONParser parser = new JSONParser();
        Object o1;
        Object o2;
        try {
            o1 = parser.parse(data1);
        } catch (Exception e) {
            o1 = data1;
        }
        try {
            o2 = parser.parse(data2);
        } catch (Exception e) {
            o2 = data2;
        }
        String r = calc(o1, o2);
        if (r.length() > 0) {
            System.out.println("YES");
            System.out.println(r);
        } else {
            System.out.println("NO");
        }
    }

    static class Pair {
        Object o1;
        Object o2;

        Pair(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }
    }

    static String calc(Object o1, Object o2) {
        Map<Integer, List<Pair>> m1 = traverse(o1);
        Map<Integer, List<Pair>> m2 = traverse(o2);
        List<Pair> pairs = new ArrayList<>();
        for (Integer level1 : m1.keySet()) {
            List<Pair> l1 = m1.get(level1);
            List<Pair> l2 = new ArrayList<>();
            if (m2.containsKey(level1)) {
                l2 = m2.get(level1);
            }
            Map<String, String> mm1 = new HashMap<>();
            for (Pair p : l1) {
                mm1.put(toString(p.o1), toString(p.o2));
            }
            Map<String, String> mm2 = new HashMap<>();
            for (Pair p : l2) {
                mm2.put(toString(p.o1), toString(p.o2));
            }
            for (Map.Entry<String, String> e : mm1.entrySet()) {
                if (mm2.containsKey(e.getKey())) {
                    String v = mm2.get(e.getKey());
                    if (v.equals(e.getValue())) {
                        pairs.add(new Pair(e.getKey(), e.getValue()));
                    }
                }
            }
        }
        String result = "";
        for (Pair p : pairs) {
            if (p.o2.toString().length() > result.length()) {
                result = p.o2.toString();
            }
        }
        return result;
    }

    static Map<Integer, List<Pair>> traverse(Object r) {
        LinkedList<Object> queue = new LinkedList<>();
        queue.add(r);
        Map<Integer, List<Pair>> map = new HashMap<>();
        int level = 0;
        List<Pair> pairs = new ArrayList<>();
        map.put(level, pairs);
        while (!queue.isEmpty()) {
            Object o = queue.poll();
            level++;
            pairs = new ArrayList<>();
            map.put(level, pairs);
            if (o instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) o;
                for (Object k : jsonObject.keySet()) {
                    Object v = jsonObject.get(k);
                    if (v instanceof JSONObject || v instanceof JSONArray) {
                        queue.add(v);
                    } else {
                        pairs.add(new Pair(k, v));
                    }
                }
            } else if (o instanceof JSONArray) {
                JSONArray array = (JSONArray) o;
                queue.addAll(array);
            } else {
                if (o != null) {
                    pairs.add(new Pair(Integer.toString(level), o.toString()));
                } else {
                    pairs.add(new Pair(Integer.toString(level), ""));
                }
            }
        }
        return map;
    }

    static String readFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    static String toString(Object o) {
        if (o != null) {
            return o.toString();
        }
        return "null";
    }
}
