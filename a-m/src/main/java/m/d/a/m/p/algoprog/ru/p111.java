package m.d.a.m.p.algoprog.ru;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p111 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            String a = input.nextLine();
            if (a.length() == 0) {
                break;
            }
            list.add(a);
        }
        long x = 0;
        long y = 0;
        for (String c : list) {
            String[] a = c.split(" ");
            String direction = a[0];
            long value = Long.parseLong(a[1]);
            switch (direction) {
                case "East":
                    x += value;
                    break;
                case "West":
                    x -= value;
                    break;
                case "North":
                    y += value;
                    break;
                case "South":
                    y -= value;
                    break;
            }
        }
        System.out.println(x + " " + y);
    }
}
