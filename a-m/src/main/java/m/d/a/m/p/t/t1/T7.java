package m.d.a.m.p.t.t1;

import java.util.Arrays;

public class T7 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 3, 4};
        System.out.println(Arrays.toString(a));
        int[] r = mergeSort(a);
        System.out.println(Arrays.toString(r));
    }

    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int pivot = a.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(a, 0, pivot));
        int[] right = mergeSort(Arrays.copyOfRange(a, pivot, a.length));
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftCur = 0;
        int rightCur = 0;
        int resultCur = 0;
        while (leftCur < left.length && rightCur < right.length) {
            if (left[leftCur] < right[rightCur]) {
                result[resultCur++] = left[leftCur++];
            } else {
                result[resultCur++] = right[rightCur++];
            }
        }
        while (leftCur < left.length) {
            result[resultCur++] = left[leftCur++];
        }
        while (rightCur < right.length) {
            result[resultCur++] = right[rightCur++];
        }
        return result;
    }
}
