package m.d.a.m.p.lt.problems;

import java.util.ArrayList;
import java.util.List;

public class DesignHitCounter {
    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        HitCounter c = new HitCounter();
        c.hit(10);
        System.out.println(c.getHits(10));
    }

    static class HitCounter {
        private List<Integer> hits;
        private int lastTime;

        public HitCounter() {
            hits = new ArrayList<>();
            lastTime = -1;
        }

        public void hit(int timestamp) {
            hits.add(0, timestamp);
            lastTime += 1;
        }

        public int getHits(int timestamp) {
            if (hits.size() == 0) return 0;
            while (lastTime > 0 && hits.get(lastTime) < timestamp - 299) lastTime -= 1;
            return (hits.get(lastTime) < timestamp - 299) ? 0 : lastTime + 1;
        }
    }
}
