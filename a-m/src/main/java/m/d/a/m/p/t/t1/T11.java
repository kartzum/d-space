package m.d.a.m.p.t.t1;

// https://praktikum.yandex.ru/algorithms
// https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions

// Arrays
// MoveZeros. https://www.educative.io/m/move-zeros-left. The concept of reader/writer indexes.

// Sorts.
// Bubble Sort. https://www.geeksforgeeks.org/bubble-sort/

public class T11 {
    public static void main(String[] args) {
        // Arrays.MoveZeros.tests();
        Arrays.BubbleSort.tests();
    }

    static class Arrays {
        static class MoveZeros {
            static void moveZerosToLeft(int[] A) {
                int reader = A.length - 1;
                int writer = A.length - 1;
                while (reader >= 0) {
                    if (A[reader] != 0) {
                        A[writer] = A[reader];
                        writer--;
                    }
                    reader--;
                }
                while (writer >= 0) {
                    A[writer] = 0;
                    writer--;
                }
            }

            static void tests() {
                int[] A = new int[]{1, 0, 2, 0, 0, 3};
                System.out.println(java.util.Arrays.toString(A));
                moveZerosToLeft(A);
                System.out.println(java.util.Arrays.toString(A));
            }
        }

        static class BubbleSort {
            static void bubbleSort(int arr[]) {
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - 1 - i; j++) {
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
            }

            static void tests() {
                int[] arr = new int[]{3, 2, 1};
                bubbleSort(arr);
                System.out.println(java.util.Arrays.toString(arr));
            }
        }
    }
}
