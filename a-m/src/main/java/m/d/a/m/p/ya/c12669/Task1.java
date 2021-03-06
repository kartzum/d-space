package m.d.a.m.p.ya.c12669;

import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        boolean log = false;
        // calcTest1(log);
        // calcTest2(log);

        run(log);
    }

    private static void run(boolean log) {
        Object[] p = read(log);
        Integer n = (Integer) p[0];
        Integer x = (Integer) p[1];
        Integer k = (Integer) p[2];
        List<Integer> v = (List<Integer>) p[3];
        if (log) {
            System.out.println("n= " + n + ", x= " + x + ", k= " + k + ", v= " + v);
        }
        int r = calc(v, x, k, log);
        if (log) {
            System.out.println(r);
        }
        write(r);
    }

    private static Object[] read(boolean log) {
        String path = null;
        if (new File("./input.txt").exists()) {
            path = "./input.txt";
        } else if (new File("./data/ya/c12669/1/input.txt").exists()) {
            path = "./data/ya/c12669/1/input.txt";
        }
        Integer n = null;
        Integer x = null;
        Integer k = null;
        ArrayList<Integer> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int i = 0;
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (i == 0) {
                    String[] vars = line.split(" ");
                    try {
                        if (vars.length > 0) {
                            n = new Integer(vars[0]);
                            x = new Integer(vars[1]);
                            k = new Integer(vars[2]);
                        }
                    } catch (NumberFormatException e) {
                        n = null;
                        x = null;
                        k = null;
                    }
                } else if (i == 1) {
                    String[] vars = line.split(" ");
                    for (String var : vars) {
                        Integer v;
                        try {
                            v = new Integer(var);
                        } catch (NumberFormatException e) {
                            v = null;
                        }
                        if (v != null) {
                            values.add(v);
                        }
                    }
                }

                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Object[]{n, x, k, values};
    }

    private static void write(Integer r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./output.txt"))) {
            bw.write(r.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calcTest1(boolean log) {
        List<Integer> timers = new ArrayList<>();
        timers.add(5);
        timers.add(22);
        timers.add(17);
        timers.add(13);
        timers.add(8);
        int step = 7;
        int finish = 12;
        int r = calc(timers, step, finish, log);
        if (log) {
            System.out.println(r);
        }
    }

    private static void calcTest2(boolean log) {
        List<Integer> timers = new ArrayList<>();
        timers.add(1);
        timers.add(2);
        timers.add(3);
        timers.add(4);
        timers.add(5);
        timers.add(6);
        int step = 5;
        int finish = 10;
        int r = calc(timers, step, finish, log);
        if (log) {
            System.out.println(r);
        }
    }

    private static int calc(List<Integer> timers, int step, int finish, boolean log) {
        int k = 0;
        LinkedHashSet<Integer> buffer = new LinkedHashSet<>();
        for (Integer timer : timers) {
            buffer.add(timer);
        }
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        do {
            int min = buffer.stream().min(Comparator.comparing(Integer::valueOf)).get();
            if (!result.contains(min)) {
                result.add(min);
                buffer.remove(min);

                int minNew = min + step;
                do {
                    for (int i = 0; i < timers.size(); i++) {
                        timers.set(i, timers.get(i) + step);
                        buffer.add(timers.get(i));
                    }

                    int minCurrent = buffer.stream().min(Comparator.comparing(Integer::valueOf)).get();
                    if (minCurrent < minNew) {
                        break;
                    }
                }
                while (true);
            }
            if (log) {
                System.out.println(min);
            }
            k++;
        } while (k < finish);
        if (result.size() > 0) {
            return (Integer) result.toArray()[result.size() - 1];
        }
        return 0;
    }
}
