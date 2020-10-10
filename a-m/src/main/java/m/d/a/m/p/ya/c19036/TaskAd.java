package m.d.a.m.p.ya.c19036;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TaskAd {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String urlRaw = r.readLine();
            String port = r.readLine();
            String a = r.readLine();
            String b = r.readLine();
            String url = urlRaw + ":" + port + "?" + "a=" + a + "&" + "b=" + b;
            long sum = calc(url);
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static long calc(String url) {
        long sum = 0;
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
                    Long x;
                    try {
                        x = Long.parseLong(value.toString());
                    } catch (NumberFormatException e) {
                        x = null;
                    }
                    if (x != null) {
                        sum += x;
                    }
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e.getMessage() + ": " + url + ": " + response.toString());
        }
        return sum;
    }
}
