package m.d.a.m.p.ya.c27049;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c27049d {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String urlRaw = reader.readLine();
            String port = reader.readLine();
            String a = reader.readLine();
            String b = reader.readLine();
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
                    if (x != null) {
                        result.add(x);
                    }
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e.getMessage() + ": " + url + ": " + response);
        }
        Collections.sort(result);
        return result;
    }
}
