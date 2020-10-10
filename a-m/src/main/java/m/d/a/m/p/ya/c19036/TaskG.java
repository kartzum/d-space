package m.d.a.m.p.ya.c19036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskG {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        boolean log = false;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String knAsString = r.readLine();
        String kAsString = knAsString.split(" ")[0];
        String nAsString = knAsString.split(" ")[1];
        String sAsString = r.readLine();
        int k = Integer.parseInt(kAsString);
        int n = Integer.parseInt(nAsString);
        List<Integer> scores = new ArrayList<>();
        for (String s : sAsString.split(" ")) {
            scores.add(Integer.parseInt(s));
        }
        int result = calc(k, n, scores, log);
        System.out.println(prepareResult(result));
    }

    private static int calc(int a, int b, List<Integer> scores, boolean log) {
        int aCounter = 0;
        int bCounter = 0;

        for (int i = 0; i < scores.size(); i++) {
            int s = scores.get(i);

            int aI = s % 5 == 0 ? 1 : 0;
            int bI = s % 3 == 0 ? 1 : 0;

            if ((s % 5 == 0 && s % 3 == 0) || (s % 5 == 1 && s % 3 == 1)) {
                aI = 0;
                bI = 0;
            }

            aCounter += aI;
            bCounter += bI;

            if (log) {
                System.out.println(
                        "score ="
                                + s + ", k5= "
                                + s % 5 + ", k3= "
                                + s % 3 + ", aI= "
                                + aI + ", bI= "
                                + bI + ", a= "
                                + aCounter + ", b= " + bCounter);
            }

            if (aCounter == a || bCounter == b) {
                return aCounter > bCounter ? 1 : 2;
            }
        }

        if (aCounter != bCounter) {
            return aCounter > bCounter ? 1 : 2;
        }
        return 0;
    }

    private static String prepareResult(int r) {
        String rAsString = "";
        if (r == 1) {
            rAsString = "Vasya";
        } else if (r == 2) {
            rAsString = "Petya";
        } else {
            rAsString = "Draw";
        }
        return rAsString;
    }
}
