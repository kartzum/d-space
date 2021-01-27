package m.d.a.m.p.t.t1;

// https://praktikum.yandex.ru/algorithms
// https://www.educative.io/blog/cracking-top-facebook-coding-interview-questions

// Arrays
// MoveZeros. https://www.educative.io/m/move-zeros-left. The concept of reader/writer indexes.
// Merge Overlapping Intervals. https://www.educative.io/m/merge-overlapping-intervals

// Sorts.
// Bubble Sort. https://www.geeksforgeeks.org/bubble-sort/

// Linked Lists
// Add Two Integers. https://www.educative.io/m/add-two-integers
// Merge Two Sorted Linked Lists. https://www.educative.io/m/merge-two-sorted-linked-lists

import java.util.ArrayList;

public class T11 {
    public static void main(String[] args) {
        // Arrays.MoveZeros.tests();
        // Sorts.BubbleSort.tests();
        // Arrays.MergeIntervals.tests();
        // LinkedLists.AddIntegers.tests();
        LinkedLists.MergeSortList.tests();
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

    static class Sorts {
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

    static class LinkedLists {
        static class AddIntegers {
            static class LinkedListNode {
                LinkedListNode next;
                int data;

                LinkedListNode() {
                }

                LinkedListNode(int data, LinkedListNode next) {
                    this.data = data;
                    this.next = next;
                }
            }

            static LinkedListNode add_integers(
                    LinkedListNode integer1,
                    LinkedListNode integer2) {

                LinkedListNode result = null;
                LinkedListNode last = null;
                int carry = 0;

                while (
                        integer1 != null ||
                                integer2 != null ||
                                carry > 0) {
                    int first = (integer1 == null ? 0 : integer1.data);
                    int second = (integer2 == null ? 0 : integer2.data);
                    int sum = first + second + carry;

                    LinkedListNode pNew = new LinkedListNode(sum % 10, null);
                    carry = sum / 10;

                    if (result == null) {
                        result = pNew;
                    } else {
                        last.next = pNew;
                    }

                    last = pNew;

                    if (integer1 != null) {
                        integer1 = integer1.next;
                    }
                    if (integer2 != null) {
                        integer2 = integer2.next;
                    }
                }
                return result;
            }

            static void tests() {
                LinkedListNode l1N1 = new LinkedListNode(1, null);
                LinkedListNode l1N2 = new LinkedListNode(2, null);
                LinkedListNode l1N3 = new LinkedListNode(3, null);
                l1N1.next = l1N2;
                l1N2.next = l1N3;

                LinkedListNode l2N1 = new LinkedListNode(1, null);
                LinkedListNode l2N2 = new LinkedListNode(2, null);
                l2N1.next = l2N2;

                LinkedListNode n1 = add_integers(l1N1, l2N1);
                while (n1 != null) {
                    System.out.println(n1.data);
                    n1 = n1.next;
                }
            }
        }

        static class MergeSortList {
            static class LinkedListNode {
                LinkedListNode next;
                int data;

                LinkedListNode() {
                }

                LinkedListNode(int data, LinkedListNode next) {
                    this.data = data;
                    this.next = next;
                }
            }

            public static LinkedListNode merge_sorted(
                    LinkedListNode head1,
                    LinkedListNode head2) {
                if (head1 == null) {
                    return head2;
                } else if (head2 == null) {
                    return head1;
                }


                LinkedListNode mergedHead = null;
                if (head1.data <= head2.data) {
                    mergedHead = head1;
                    head1 = head1.next;
                } else {
                    mergedHead = head2;
                    head2 = head2.next;
                }

                LinkedListNode mergedTail = mergedHead;

                while (head1 != null && head2 != null) {
                    LinkedListNode temp = null;
                    if (head1.data <= head2.data) {
                        temp = head1;
                        head1 = head1.next;
                    } else {
                        temp = head2;
                        head2 = head2.next;
                    }

                    mergedTail.next = temp;
                    mergedTail = temp;
                }

                if (head1 != null) {
                    mergedTail.next = head1;
                } else if (head2 != null) {
                    mergedTail.next = head2;
                }

                return mergedHead;
            }

            static void tests() {
                LinkedListNode l1N1 = new LinkedListNode(1, null);
                LinkedListNode l1N2 = new LinkedListNode(2, null);
                LinkedListNode l1N3 = new LinkedListNode(3, null);
                l1N1.next = l1N2;
                l1N2.next = l1N3;

                LinkedListNode l2N1 = new LinkedListNode(1, null);
                LinkedListNode l2N2 = new LinkedListNode(2, null);
                l2N1.next = l2N2;

                LinkedListNode n1 = merge_sorted(l1N1, l2N1);
                while (n1 != null) {
                    System.out.println(n1.data);
                    n1 = n1.next;
                }
            }
        }
    }
}