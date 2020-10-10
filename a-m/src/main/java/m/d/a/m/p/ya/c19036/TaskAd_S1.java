// https://dzone.com/articles/how-to-implement-get-and-post-request-through-simp
// https://www.baeldung.com/httpurlconnection-post
// https://code.google.com/archive/p/json-simple/

package m.d.a.m.p.ya.c19036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class TaskAd_S1 {
    public static void main(String[] args) {
        boolean prod = true;
        boolean test = false;
        boolean debug = false;
        if (test) {
            tests(debug);
        }
        if (prod) {
            run(prod);
        }
    }

    static void tests(boolean debug) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        calc(debug, url);
    }

    static void run(boolean debug) {
        // http://127.0.0.1:7777?a=2&b=4
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String urlRaw = r.readLine();
            String port = r.readLine();
            String a = r.readLine();
            String b = r.readLine();
            String url = urlRaw + ":" + port + "?" + "a=" + a + "&" + "b=" + b;
            if (debug) {
                System.out.println(url);
            }
            int sum = calc(debug, url);
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int calc(boolean debug, String url) {
        int sum = 0;
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
                if (debug) {
                    System.out.println(response.toString());
                }
                /*JSONObject json = (JSONObject) new JSONParser().parse(response.toString());
                for (Object value : json.values()) {
                    Integer x;
                    try {
                        x = Integer.parseInt(value.toString());
                    } catch (NumberFormatException e) {
                        x = null;
                    }
                    if (x != null) {
                        sum += x;
                    }
                }*/

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
                        sum += x;
                    }
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e.getMessage() + ": " + url + ": " + response.toString());
        }
        if (debug) {
            System.out.println(sum);
        }
        return sum;
    }
}
