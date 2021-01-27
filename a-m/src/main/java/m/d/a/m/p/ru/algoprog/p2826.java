// https://algoprog.ru/material/p2826

// https://www.cyberforum.ru/cpp-beginners/thread2369143.html

package m.d.a.m.p.ru.algoprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p2826 {
    public static void main(String[] args) throws IOException {
        // tests();
        run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] na = reader.readLine().split(" ");
        int n = Integer.parseInt(na[0]);
        int a = Integer.parseInt(na[1]);
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] t = reader.readLine().split(" ");
            tasks.add(task(Integer.parseInt(t[0]), Integer.parseInt(t[1])));
        }
        System.out.println(calc(tasks, a));
    }

    static class Task {
        int skill;
        int bonus;
    }

    static Task task(int skill, int bonus) {
        Task task = new Task();
        task.skill = skill;
        task.bonus = bonus;
        return task;
    }

    static void tests() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(task(3, 1));
        tasks.add(task(2, 1));
        tasks.add(task(1, 1));
        System.out.println(calc(tasks, 2));
    }

    static int calc(List<Task> tasks, int a) {
        Collections.sort(tasks, (t1, t2) -> t1.skill - t2.skill);
        int counter = 0;
        for (Task t : tasks) {
            if (t.skill <= a) {
                counter++;
                a += t.bonus;
            } else {
                break;
            }
        }
        return counter;
    }
}
