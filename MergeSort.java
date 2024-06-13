package SortingAlgos;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 3, 2, 1}; // {4, 4, 5} {1, 2, 3}
        mergeSortInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] res = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {

            if (first[i] < second[j]) {
                res[k] = first[i];
                i++;
            } else {
                res[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            res[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            res[k] = second[j];
            j++;
            k++;
        }

        return res;
    }

    public static void mergeSortInPlace(int[] arr) {
        mergeSortInPlace(arr, 0, arr.length);
    }
    //Merge sort in place
    public static void mergeSortInPlace(int[] arr, int s, int e) {
        if ((e - s) == 1) {
            return;
        }

        int mid = (s + e)/ 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }      // {5, 4, 3, 2, 1}

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] res = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {

            if (arr[i] < arr[j]) {
                res[k] = arr[i];
                i++;
            } else {
                res[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            res[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            res[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < res.length; l++) {
            arr[s+l] = res[l];
        }
    }
}




