package m.d.a.m.p.ya.c19036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskSt {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String j = r.readLine();
        String s = r.readLine();
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (j.indexOf(c) >= 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
