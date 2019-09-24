package m.d.a.m.p.recursion;

public class Anagram {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        new Solution().execute("cats");
    }

    private static class Solution {
        char[] data;
        int size;
        int count;

        void execute(String text) {
            data = text.toCharArray();
            size = data.length;
            count = 0;
            doExecute(size);
        }

        private void doExecute(int newSize) {
            if (newSize == 1) return;
            for (int j = 0; j < newSize; j++) {
                doExecute(newSize - 1);
                if (newSize == 2) {
                    dispaly();
                }
                rotate(newSize);
            }
        }

        private void dispaly() {
            if (count < 99) {
                System.out.print(" ");
            }
            if (count < 9) {
                System.out.print(" ");
            }
            System.out.print(++count + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(data[j]);
            }
            System.out.print("   ");
            System.out.flush();
            if (count % 6 == 0) {
                System.out.println();
            }
        }

        private void rotate(int newSize) {
            int j;
            int position = size - newSize;
            char temp = data[position];
            for (j = position + 1; j < size; j++) {
                data[j - 1] = data[j];
            }
            data[j - 1] = temp;
        }
    }
}
