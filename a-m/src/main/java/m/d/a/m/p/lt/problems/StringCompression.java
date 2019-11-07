package m.d.a.m.p.lt.problems;

public class StringCompression {
    public static void main(final String[] args) {
        test1();
        //test2();
    }

    static void test1() {
        execute1(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
    }

    static void test2() {
        execute2(new char[]{'a'});
        execute2(new char[]{'a', 'b', 'b', 'b'});
        execute2(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        execute2(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
    }

    private static void execute1(char[] a) {
        System.out.println(a);
        System.out.println(new Solution1().compress(a));
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    private static void execute2(char[] a) {
        System.out.println(a);
        System.out.println(new Solution2().compress(a));
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    static class Solution2 {
        public int compress(char[] chars) {
            int i = 0;
            int k = 0;
            int a = 0;
            while (i < chars.length) {
                char c = chars[i];
                int j = i + 1;
                while (j < chars.length && c == chars[j]) {
                    j++;
                }
                int l = j - i;
                if (l == 1) {
                    k += 1;
                    chars[a] = chars[i];
                    a += 1;
                } else {
                    k += 2;
                    chars[a] = chars[i];
                    char[] t = Integer.toString(l).toCharArray();
                    for (int f = 0; f < t.length; f++) {
                        chars[a + f + 1] = t[f];
                    }
                    a += 1 + t.length;
                }
                i = j;
            }
            /*int p = a;
            while (p < chars.length) {
                chars[p] = ' ';
                p++;
            }*/
            return k;
        }
    }

    static class Solution1 {
        public int compress(char[] chars) {
            int len = chars.length;
            if (len < 2)
                return len;
            int i = 0; // slow pointer
            int j = 0; // fast pointer
            int head = 0; // writing head pointer

            while (j <= len) {
                while ((j < len) && (chars[i] == chars[j]))
                    j++;
                chars[head++] = chars[i];
                int count = j - i;
                if (count > 1) {
                    String s = Integer.toString(count);
                    for (int k = 0; k < s.length(); k++)
                        chars[head++] = s.charAt(k);
                }
                i = j;
                j++;
            }
            return head;
        }
    }
}
