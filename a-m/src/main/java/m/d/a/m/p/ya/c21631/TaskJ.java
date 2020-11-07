package m.d.a.m.p.ya.c21631;

import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskJ {
    public static void main(String[] args) {
        // tests();
        run();
    }

    static void run() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line1 = r.readLine();
            String line2 = r.readLine();
            List<String> result = calc(line1, line2);
            print(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<String> calc(String line1, String line2) {
        ArrayList<String> result = new ArrayList<>();
        if (line1 != null && line2 != null) {
            if (line1.length() > 0 && line2.length() > 0) {
                Map<String, List<String>> m1 = parseString(line1);
                Map<String, List<String>> m2 = parseString(line2);
                List<String> values = collectValues(m1, m2);
                if (values.size() > 0) {
                    String max = max(values);
                    result.add("YES");
                    result.add(max);
                } else {
                    result.add("NO");
                }
            } else {
                result.add("NO");
            }
            return result;
        } else {
            result.add("NO");
            return result;
        }
    }

    static Map<String, List<String>> parseString(String s) {
        JSONParser parser = new JSONParser();
        Map<String, List<String>> map = new HashMap<>();
        try {
            parser.parse(s, new JContentHandler(map));
        } catch (ParseException e) {
            map.put(s, Collections.singletonList("ba714cb9-2c2a-4cf6-9cdf-3501ab934eb3"));
        }
        return map;
    }

    static class JContentHandler implements ContentHandler {
        List<String> path = new ArrayList<>();
        Map<String, List<String>> map;

        JContentHandler(Map<String, List<String>> map) {
            this.map = map;
        }

        @Override
        public void startJSON() throws ParseException, IOException {

        }

        @Override
        public void endJSON() throws ParseException, IOException {

        }

        @Override
        public boolean startObject() throws ParseException, IOException {
            return true;
        }

        @Override
        public boolean endObject() throws ParseException, IOException {
            return true;
        }

        @Override
        public boolean startObjectEntry(String key) throws ParseException, IOException {
            path.add(key);
            return true;
        }

        @Override
        public boolean endObjectEntry() throws ParseException, IOException {
            if (path.size() > 0) {
                path.remove(path.size() - 1);
            }
            return true;
        }

        @Override
        public boolean startArray() throws ParseException, IOException {
            return true;
        }

        @Override
        public boolean endArray() throws ParseException, IOException {
            return true;
        }

        @Override
        public boolean primitive(Object value) throws ParseException, IOException {
            String v = "";
            if (value != null) {
                v = value.toString();
            }
            StringBuilder builder = new StringBuilder();
            for (String p : path) {
                builder.append(p);
            }
            String key = builder.toString();
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(key);
            return true;
        }
    }

    static List<String> collectValues(Map<String, List<String>> m1, Map<String, List<String>> m2) {
        List<String> r = new ArrayList<>();
        for (String k : m1.keySet()) {
            if (m2.containsKey(k)) {
                List<String> l1 = m1.get(k);
                List<String> l2 = m2.get(k);
                if (commonKeys(l1, l2)) {
                    r.add(k);
                }
            }
        }
        return r;
    }

    static boolean commonKeys(List<String> l1, List<String> l2) {
        Set<String> r = new HashSet<>();
        for (String s1 : l1) {
            if (l2.contains(s1)) {
                r.add(s1);
            }
        }
        for (String s2 : l2) {
            if (l1.contains(s2)) {
                r.add(s2);
            }
        }
        return r.size() > 0;
    }

    static String max(List<String> l) {
        String m = "";
        for (String s : l) {
            if (s.length() > m.length()) {
                m = s;
            }
        }
        return m;
    }

    static void tests() {
        // test1();
        test2();
    }

    static void test1() {
        JSONParser parser = new JSONParser();
        // String text1 = "\"just text\"";
        // String text1 = "1.0e+10";
        String text1 = "null";
        try {
            Object jsonObject = parser.parse(text1);
            String jsonObjectAsString = (String) jsonObject;
            System.out.println(jsonObjectAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void test2() {
        print(calc(
                "[{\"a\": \"text value\", \"b\": {}}, {\"a\": true}, {\"a\": \"value\", \"b\": 1}]",
                "[{\"a\": null, \"b\": 1.0}, {\"a\": \"text value\"}]"));
        /*print(calc("\"just text\"", "\"just text\""));
        print(calc("1.0e+10", "null"));
        print(calc("{\"a\":\" \", \"b\":\"   \", \"c\":\"  \"}", "{\"c\":\"  \",\"b\": \"   \", \"a\":\" \"}"));
        print(calc(null, null));
        print(calc(null, ""));
        print(calc("", null));
        print(calc("", ""));
        print(calc("{\"a\":\" \", \"b\":\"____\", \"c\":\"  \"}", "{\"c\":\"  \",\"b\": \"___\", \"a\":\" \"}"));
        print(calc("{\"a\":\" \", \"b\":\"____\", \"c\":\"  \"}", "{\"c\":\"  \",\"b\": \"____\", \"a\":\" \"}"));
        print(
                calc(
                        "[{\"a\": \"text value\", \"b\": { \"b\": \"text value 2\" }}, {\"a\": true}, {\"a\": \"value\", \"b\": 1}]",
                        "[{\"a\": null, \"b\": { \"b\": \"text value 2\" }}, {\"a\": \"text value\"}]")
        );*/
    }

    static void print(List<String> l) {
        for (String s : l) {
            System.out.println(s);
        }
    }
}
