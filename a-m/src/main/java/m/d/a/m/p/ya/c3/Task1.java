package m.d.a.m.p.ya.c3;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        String path = null;
        if (new File("./input.txt").exists()) {
            path = "./input.txt";
        } else if (new File("./data/ya/c3/input.txt").exists()) {
            path = "./data/ya/c3/input.txt";
        }
        Long v1 = null;
        Long v2 = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] vars = line.split(" ");
                try {
                    if (vars.length > 1) {
                        v1 = new Long(vars[0]);
                        v2 = new Long(vars[1]);
                    }
                } catch (NumberFormatException e) {
                    v1 = null;
                    v2 = null;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (v1 != null && v2 != null) {
            long r = v1 + v2;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("./output.txt"))) {
                bw.write(Long.toString(r));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
