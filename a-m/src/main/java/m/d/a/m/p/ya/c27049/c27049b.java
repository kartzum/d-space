package m.d.a.m.p.ya.c27049;

import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class c27049b {
    public static void main(String[] args) throws IOException, ParseException {
        tests();
        //run();
    }

    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = reader.readLine();
        String[] temp = reader.readLine().split(" ");
        calc(code, temp[0], temp[1]);
    }

    static void tests() throws IOException {
        calc("MONTH", "2020-01-10", "2020-03-25");
        calc("WEEK", "2020-01-26", "2020-03-23");
    }

    static void calc(String code, String d1, String d2) {
        List<List<LocalDateTime>> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDate1 = LocalDate.parse(d1, formatter).atTime(LocalTime.MIN);
        LocalDateTime localDate2 = LocalDate.parse(d2, formatter).atTime(LocalTime.MIN);
        if ("MONTH".equals(code)) {
            LocalDateTime current = localDate1.with(TemporalAdjusters.firstDayOfMonth()).truncatedTo(ChronoUnit.DAYS);
            while (current.isBefore(localDate2)) {
                List<LocalDateTime> line = new ArrayList<>();
                LocalDateTime begin = current;
                if (begin.isBefore(localDate1)) {
                    line.add(localDate1);
                } else {
                    line.add(begin);
                }
                LocalDateTime end = current.plusMonths(1).minusDays(1);
                if (end.isAfter(localDate2)) {
                    line.add(localDate2);
                } else {
                    line.add(end);
                }
                result.add(line);
                current = current.plusMonths(1);
            }
        } else if ("WEEK".equals(code)) {
            LocalDateTime current = localDate1.with(TemporalAdjusters.firstDayOfMonth()).truncatedTo(ChronoUnit.DAYS);
            while (current.isBefore(localDate2)) {
                List<LocalDateTime> line = new ArrayList<>();
                LocalDateTime begin = current;
                if (begin.isBefore(localDate1)) {
                    line.add(localDate1);
                } else {
                    line.add(begin);
                }
                LocalDateTime end = current.plusDays(6);
                if (end.isAfter(localDate2)) {
                    line.add(localDate2);
                } else {
                    line.add(end);
                }
                result.add(line);
                current = current.plusDays(7);
            }
        }
        System.out.println(result.size());
        for (List<LocalDateTime> line : result) {
            LocalDateTime begin = line.get(0);
            LocalDateTime end = line.get(1);
            System.out.println(begin.format(formatter) + " " + end.format(formatter));
        }
    }
}
