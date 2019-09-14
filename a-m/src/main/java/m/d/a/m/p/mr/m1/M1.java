package m.d.a.m.p.mr.m1;

import java.util.*;

public class M1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String d[] = scanner.nextLine().split(" ");
        List<String> list = Arrays.asList(d);
        long r = 0;
        for (String s : list) {
            long l = Long.parseLong(s);
            r += l;
        }
        System.out.println(r);
        scanner.close();
    }
}
