package m.d.a.m.p.ya.c3;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String data;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (data != null) {
            // System.out.println(data);
            Long v1 = null;
            Long v2 = null;
            String[] vars = data.split(" ");
            try {
                if (vars.length > 1) {
                    v1 = new Long(vars[0]);
                    v2 = new Long(vars[1]);
                }
            } catch (NumberFormatException e) {
                v1 = null;
                v2 = null;
            }
            if (v1 != null && v2 != null) {
                long r = v1 + v2;
                System.out.println(Long.toString(r));
            }
        }
    }
}
