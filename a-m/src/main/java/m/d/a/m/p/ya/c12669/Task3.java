package m.d.a.m.p.ya.c12669;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        boolean log = false;
        // calcTest2(log);
        Object[] p = read(log);
        int a = (Integer) p[0];
        int b = (Integer) p[1];
        List<Integer> scores = (List<Integer>) p[2];
        if (log) {
            System.out.println("a= " + a + ", b= " + b + ", v= " + scores);
        }
        int r = calc(a, b, scores, log);
        if (log) {
            System.out.println(r + ", " + prepareResult(r));
        }
        write(prepareResult(r));
    }

    private static Object[] read(boolean log) {
        String path = null;
        if (new File("./input.txt").exists()) {
            path = "./input.txt";
        } else if (new File("./data/ya/c12669/3/input.txt").exists()) {
            path = "./data/ya/c12669/3/input.txt";
        }
        Integer a = null;
        Integer b = null;
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
                        if (vars.length > 1) {
                            a = new Integer(vars[0]);
                            b = new Integer(vars[1]);
                        }
                    } catch (NumberFormatException e) {
                        a = null;
                        b = null;
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

        return new Object[]{a, b, values};
    }

    private static void write(String r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./output.txt"))) {
            bw.write(r);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void calcTest1(boolean log) {
        int a = 3;
        int b = 10;
        int[] s = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> scores = new ArrayList<>();
        for (int i1 : s) {
            scores.add(i1);
        }

        int r = calc(a, b, scores, log);

        if (log) {
            System.out.println(r + ", " + prepareResult(r));
        }
    }

    private static void calcTest2(boolean log) {
        int a = 4;
        int b = 12;
        int[] s = new int[]{5, 10, 15, 20, 3, 6, 9, 25, 30, 12, 21, 24};
        List<Integer> scores = new ArrayList<>();
        for (int i1 : s) {
            scores.add(i1);
        }

        int r = calc(a, b, scores, log);

        if (log) {
            System.out.println(r + ", " + prepareResult(r));
        }
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
