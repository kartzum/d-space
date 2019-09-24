package m.d.a.m.p.recursion;

public class BinarySearch {
    static int[] data = new int[]{1, 2, 3, 7, 9, 10, 15, 18, 21, 25};

    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        int i = new Solution().execute(data, 18);
        System.out.println(i);
        /*if (i >= 0) {
            System.out.println(data[i]);
        }*/
    }

    private static void test2() {
        int i = new Solution2().execute(data, 0, data.length, 18);
        System.out.println(i);
        if (i >= 0) {
            System.out.println(data[i]);
        }
    }

    private static class Solution {
        int execute(int[] arr, int v) {
            int l = 0;
            int r = arr.length;
            while (l <= r) {
                int m = (r + l) / 2;
                // System.out.println(m + ", " + l + ", " + r);
                if (arr[m] == v) {
                    return m;
                }
                if (arr[m] < v) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return -1;
        }
    }

    private static class Solution2 {
        int execute(int[] arr, int l, int r, int v) {
            if (l <= r) {
                int m = (r + l) / 2;
                if (arr[m] == v) {
                    return m;
                }
                if (arr[m] < v) {
                    return execute(arr, m + 1, r, v);
                }
                return execute(arr, l, m - 1, v);
            }
            return -1;
        }
    }
}
