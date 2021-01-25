package m.d.a.m.p.t.t1;

// https://praktikum.yandex.ru/algorithms
// https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions

// Arrays
// MoveZeros. https://www.educative.io/m/move-zeros-left. The concept of reader/writer indexes.
// Merge Overlapping Intervals. https://www.educative.io/m/merge-overlapping-intervals

// Sorts.
// Bubble Sort. https://www.geeksforgeeks.org/bubble-sort/

import java.util.ArrayList;

public class T11 {
    public static void main(String[] args) {
        // Arrays.MoveZeros.tests();
        // Arrays.BubbleSort.tests();
        Arrays.MergeIntervals.tests();
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

        static class MergeIntervals {
            static class Pair {
                public int first;
                public int second;

                public Pair(int x, int y) {
                    this.first = x;
                    this.second = y;
                }
            }

            static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
                ArrayList<Pair> result = new ArrayList<>();
                Pair first = v.get(0);
                result.add(new Pair(first.first, first.second));
                for (int i = 1; i < v.size(); i++) {
                    int x1 = v.get(i).first;
                    int y1 = v.get(i).second;
                    int x2 = v.get(v.size() - 1).first;
                    int y2 = v.get(v.size() - 1).second;
                    if (y2 > x1) {
                        result.get(result.size() - 1).second = Math.max(y1, y2);
                    } else {
                        result.add(new Pair(x1, y1));
                    }
                }
                return result;
            }

            static void tests() {
                ArrayList<Pair> v = new ArrayList<Pair>();

                v.add(new Pair(1, 5));
                v.add(new Pair(3, 7));
                v.add(new Pair(4, 6));
                v.add(new Pair(6, 8));
                v.add(new Pair(10, 12));
                v.add(new Pair(11, 15));

                ArrayList<Pair> r = mergeIntervals(v);
                for (Pair p : r) {
                    System.out.println(p.first + ", " + p.second);
                }
            }
        }
    }
}