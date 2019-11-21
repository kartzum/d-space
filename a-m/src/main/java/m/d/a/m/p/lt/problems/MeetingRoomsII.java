package m.d.a.m.p.lt.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(final String[] args) {
        test1();
    }

    private static void test1() {
        int[][] intervals = new int[][]{{1, 3}, {2, 4}};
        System.out.println(new Solution().minMeetingRooms(intervals));
    }

    /**
     * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
     * end = 0; } Interval(int s, int e) { start = s; end = e; } }
     */
    static class Solution {

        static class Interval {
            int start;
            int end;
        }

        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null) {
                return 0;
            }
            Interval[] i = new Interval[intervals.length];
            for (int j = 0; j < intervals.length; j++) {
                i[j] = new Interval();
                i[j].start = intervals[j][0];
                i[j].end = intervals[j][1];
            }
            return minMeetingRooms(i);
        }

        public int minMeetingRooms(Interval[] intervals) {

            // Check for the base case. If there are no intervals, return 0
            if (intervals.length == 0) {
                return 0;
            }

            // Min heap
            PriorityQueue<Integer> allocator =
                    new PriorityQueue<Integer>(
                            intervals.length,
                            new Comparator<Integer>() {
                                public int compare(Integer a, Integer b) {
                                    return a - b;
                                }
                            });

            // Sort the intervals by start time
            Arrays.sort(
                    intervals,
                    new Comparator<Interval>() {
                        public int compare(Interval a, Interval b) {
                            return a.start - b.start;
                        }
                    });

            // Add the first meeting
            allocator.add(intervals[0].end);

            // Iterate over remaining intervals
            for (int i = 1; i < intervals.length; i++) {

                // If the room due to free up the earliest is free, assign that room to this meeting.
                if (intervals[i].start >= allocator.peek()) {
                    allocator.poll();
                }

                // If a new room is to be assigned, then also we add to the heap,
                // If an old room is allocated, then also we have to add to the heap with updated end time.
                allocator.add(intervals[i].end);
            }

            // The size of the heap tells us the minimum rooms required for all the meetings.
            return allocator.size();
        }
    }

}
