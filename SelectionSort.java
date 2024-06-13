package SortingAlgos;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        sortRecursion(arr, 0, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortRecursion(int[] arr, int r, int c, int small) {
        if (r == arr.length - 2) {
            return;
        }
        if (c < arr.length) {
            if (arr[c] < arr[small]) {
                small = c;
            }
            sortRecursion(arr, r, ++c, small);
        } else {
            swap(arr, small, r);
            sortRecursion(arr, ++r, r, r);
        }
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int small = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[small]) {
                    small = j;
                }
            }
            swap(arr, i, small);
        }
    }

    public static void swap(int[] arr, int first, int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
