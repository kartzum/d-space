package m.d.a.m.p.ya.c22062;

import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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

    static String filePath(String inputFile) {
        String inputFileValue = "input.txt";
        if (inputFile != null) {
            inputFileValue = inputFile;
        }
        String path = null;
        if (new File("./" + inputFileValue).exists()) {
            path = "./" + inputFileValue;
        } else if (new File("./data/ya/c22062/J/1/" + inputFileValue).exists()) {
            path = "./data/ya/c22062/J/1/" + inputFileValue;
        }
        return path;
    }

    static String readStringFromFile(String path) {
        StringBuilder builder = new StringBuilder();
        if (path != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    static List<String> calc(String line1, String line2) {
        ArrayList<String> result = new ArrayList<>();
        if (line1 != null && line2 != null && line1.length() > 0 && line2.length() > 0) {
            List<Object> p1 = parseString(line1);
            List<Object> p2 = parseString(line2);
            Map<String, List<String>> v1 = (Map<String, List<String>>) p1.get(0);
            Map<String, List<String>> v2 = (Map<String, List<String>>) p2.get(0);
            Map<String, List<String>> k1 = (Map<String, List<String>>) p1.get(1);
            Map<String, List<String>> k2 = (Map<String, List<String>>) p2.get(1);
            Collection<String> values = merge(k1, k2);
            String max = max(values);
            if (max.length() > 0) {
                result.add("YES");
                result.add(max);
            } else {
                result.add("NO");
            }
        } else {
            result.add("NO");
        }
        return result;
    }

    static List<Object> parseString(String source) {
        JSONParser parser = new JSONParser();
        Map<String, List<String>> valuesMap = new HashMap<>();
        Map<String, List<String>> keysMap = new HashMap<>();
        try {
            parser.parse(source, new JContentHandler(valuesMap, keysMap));
        } catch (ParseException e) {

        }
        List<Object> r = new ArrayList<>();
        r.add(valuesMap);
        r.add(keysMap);
        return r;
    }

    static class JContentHandler implements ContentHandler {
        List<String> path = new ArrayList<>();
        Map<String, List<String>> valuesMap;
        Map<String, List<String>> keysMap;

        JContentHandler(Map<String, List<String>> valuesMap, Map<String, List<String>> keysMap) {
            this.valuesMap = valuesMap;
            this.keysMap = keysMap;
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
            String p = builder.toString();
            if (!valuesMap.containsKey(v)) {
                valuesMap.put(v, new ArrayList<>());
            }
            valuesMap.get(v).add(p);
            if (!keysMap.containsKey(p)) {
                keysMap.put(p, new ArrayList<>());
            }
            keysMap.get(p).add(v);
            return true;
        }
    }

    static Collection<String> merge(Map<String, List<String>> m1, Map<String, List<String>> m2) {
        Set<String> result = new HashSet<>();
        for (String k1 : m1.keySet()) {
            if (m2.containsKey(k1)) {
                List<String> l1 = m1.get(k1);
                List<String> l2 = m2.get(k1);
                if ("".equals(k1)) {
                    if (l1.size() > 0 && l2.size() > 0) {
                        if (l1.get(0).equals(l2.get(0))) {
                            result.add(l1.get(0));
                        }
                    }
                } else {
                    for (String s1 : l1) {
                        if (l2.contains(s1)) {
                            result.add(s1);
                        }
                    }
                    for (String s2 : l2) {
                        if (l1.contains(s2)) {
                            result.add(s2);
                        }
                    }
                }
            }
        }
        return result;
    }

    static String max(Collection<String> l) {
        String m = "";
        for (String s : l) {
            if (s.length() > m.length()) {
                m = s;
            }
        }
        return m;
    }

    static void print(Map<String, List<String>> m) {
        for (Map.Entry<String, List<String>> entry : m.entrySet()) {
            System.out.println(entry.getKey());
            for (String v : entry.getValue()) {
                System.out.println(v);
            }
            System.out.println();
        }
    }

    static void print(List<String> l) {
        for (String s : l) {
            System.out.println(s);
        }
    }

    static void tests() {
        // test1();
        test2();
        // test3();
    }

    static void test1() {
        print((Map<String, List<String>>) parseString(readStringFromFile(filePath("input_1.json"))).get(0));
        print((Map<String, List<String>>) parseString(readStringFromFile(filePath("input_2.json"))).get(0));
    }

    static void test2() {
        print(calc(readStringFromFile(filePath("input_1.json")), readStringFromFile(filePath("input_2.json"))));
    }

    static void test3() {
        /*print(calc(
                "[{\"a\": \"text value\", \"b\": {}}, {\"a\": true}, {\"a\": \"value\", \"b\": 1}]",
                "[{\"a\": null, \"b\": 1.0}, {\"a\": \"text value\"}]"));*/
        //print(calc("\"just text\"", "\"just text\""));
        print(calc("1.0e+10", "null"));
        //print(calc("{\"a\":\" \", \"b\":\"   \", \"c\":\"  \"}", "{\"c\":\"  \",\"b\": \"   \", \"a\":\" \"}"));
        /*print(calc(null, null));
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
}
