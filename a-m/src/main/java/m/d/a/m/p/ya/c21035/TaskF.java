package m.d.a.m.p.ya.c21035;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskF {
    public static void main(String[] args) {
        run();
        // tests();
    }

    static void run() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String urlRaw = r.readLine();
            String port = r.readLine();
            String a = r.readLine();
            String b = r.readLine();
            String url = urlRaw + ":" + port + "?" + "a=" + a + "&" + "b=" + b;
            List<Integer> result = calc(url);
            for (int x : result) {
                System.out.println(x);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<Integer> calc(String url) {
        List<Integer> result = new ArrayList<>();
        StringBuilder response = new StringBuilder();
        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String responseLine;
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                JSONParser parser = new JSONParser();
                JSONArray array = (JSONArray) parser.parse(response.toString());
                for (Object value : array) {
                    Integer x;
                    try {
                        x = Integer.parseInt(value.toString());
                    } catch (NumberFormatException e) {
                        x = null;
                    }
                    if (x != null && x < 0) {
                        result.add(x);
                    }
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e.getMessage() + ": " + url + ": " + response.toString());
        }
        Collections.sort(result);
        return result;
    }

    static void tests() {
        test1();
    }

    static void test1() {
        List<Integer> result = new ArrayList<>();
        result.add(-17);
        result.add(-19);
        result.add(-3);
        Collections.sort(result);
        for (int x : result) {
            System.out.println(x);
        }
    }
}
