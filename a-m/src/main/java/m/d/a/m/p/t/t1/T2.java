package m.d.a.m.p.t.t1;

public class T2 {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test1() {
        System.out.println(new SolutionIsPalindrome().isPalindrome("121"));
        System.out.println(new SolutionIsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new SolutionIsPalindrome().isPalindrome("race a car"));
    }

    static class SolutionIsPalindrome {
        boolean isPalindrome(String x) {
            int l = 0;
            int r = x.length() - 1;
            while (l < r) {
                if (!Character.isLetterOrDigit(x.charAt(l))) {
                    l++;
                    continue;
                }
                if (!Character.isLetterOrDigit(x.charAt(r))) {
                    r--;
                    continue;
                }
                if (Character.toLowerCase(x.charAt(l)) != Character.toLowerCase(x.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

    private static void test2() {
        System.out.println(new SolutionSqrt().sqrt(16));
    }

    static class SolutionSqrt {
        int sqrt(int x) {
            long r = x;
            while (r * r > x) {
                r = (r + x / r) / 2;
            }
            return (int) r;
        }
    }
}
