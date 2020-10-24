package m.d.a.m.p.ya.c21035;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskD {
    public static void main(String[] args) {
        run();
        // tests();
    }

    static void run() {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(r.readLine());
            for (int i = 0; i < n; i++) {
                String line = r.readLine();
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(calc(lines));
    }

    static String calc(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"offers\":[");
        try {
            for (String line : lines) {
                JSONParser parser = new JSONParser();
                JSONObject offersObject = (JSONObject) parser.parse(line);
                JSONArray offersArray = (JSONArray) offersObject.get("offers");
                for (int i = 0; i < offersArray.size(); i++) {
                    Object item = offersArray.get(i);
                    JSONObject offer = (JSONObject) item;
                    String offer_id = (String) offer.get("offer_id");
                    long market_sku = (long) offer.get("market_sku");
                    long price = (long) offer.get("price");
                    String t = "{\"market_sku\": " + market_sku + ", " + "\"offer_id\": " + "\"" + offer_id + "\"" + ", " + "\"price\": " + price + "}";
                    builder.append(t);
                    builder.append(",");
                }
            }

        } catch (ParseException e) {
            throw new RuntimeException();
        }
        char c = builder.charAt(builder.length() - 1);
        if (c == ',') {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]}");
        return builder.toString();
    }


    static void tests() {
        test1();
    }

    static void test1() {
        String o1 = "{\"offers\": [{\"offer_id\": \"offer1\", \"market_sku\": 10846332, \"price\": 1490}, {\"offer_id\": \"offer2\", \"market_sku\": 682644, \"price\": 499}]}";
        String o2 = "{\"offers\": [{\"offer_id\": \"offer3\", \"market_sku\": 832784, \"price\": 14000}]}";
        List<String> lines1 = new ArrayList<>();
        lines1.add(o1);
        lines1.add(o2);
        System.out.println(calc(lines1));
    }
}
