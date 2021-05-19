package m.d.a.m.p.ya.c27049;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class c27049c {

    public static final String OFFERS = "offers";
    public static final String PRICE = "price";
    public static final String OFFER_ID = "offer_id";

    public static void main(String[] args) throws IOException, ParseException {
        //tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<JSONObject> allOffers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            JSONArray arrayOfOffers = parseOffers(reader.readLine());
            for (Object oneOfferObject : arrayOfOffers) {
                JSONObject offerJsonObject = (JSONObject) oneOfferObject;
                allOffers.add(offerJsonObject);
            }
        }
        System.out.println(calcConcatenation(allOffers));
    }

    static void tests() throws IOException {
        test1();
    }

    static void test1() throws IOException {
        String data1 = readFromFile("./data/ya/c27049/j/j1_1.json");
        String data2 = readFromFile("./data/ya/c27049/j/j1_2.json");
        String[] data = new String[]{data1, data2};
        System.out.println(calcConcatenation(2, data));
    }

    static String calcConcatenation(int n, String[] data) {
        List<JSONObject> jsonObjects = new ArrayList<>();
        for (String s : data) {
            JSONArray a = parseOffers(s);
            for (Object o : a) {
                JSONObject jsonObject = (JSONObject) o;
                jsonObjects.add(jsonObject);
            }
        }
        return calcConcatenation(jsonObjects);
    }

    static String calcConcatenation(List<JSONObject> allOffers) {
        allOffers.sort((o1, o2) -> {
            int price1 = Integer.parseInt(o1.get(PRICE).toString());
            int price2 = Integer.parseInt(o2.get(PRICE).toString());
            int i = Integer.compare(price1, price2);
            if (i != 0) {
                return i;
            }
            String offerId1 = o1.get(OFFER_ID).toString();
            String offerId2 = o2.get(OFFER_ID).toString();
            return offerId1.compareTo(offerId2);
        });
        StringBuilder buffer = new StringBuilder();
        buffer.append("{\"" + OFFERS + "\":");
        String offers = JSONArray.toJSONString(allOffers);
        buffer.append(offers);
        buffer.append("}");
        return buffer.toString();
    }

    static JSONArray parseOffers(String s) {
        JSONParser parser = new JSONParser();
        Object o;
        try {
            o = parser.parse(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = (JSONObject) o;
        return (JSONArray) jsonObject.get(OFFERS);
    }

    static String readFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
