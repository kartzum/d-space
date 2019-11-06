package m.d.a.m.p.t.t1;

public class T6 {
    public static void main(String[] args) {
        char[] s = new char[]{'a', 'b', 'c', 'd'};
        reverse(s);
        System.out.println(s);
    }

    static void reverse(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
