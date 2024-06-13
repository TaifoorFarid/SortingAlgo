package SortingAlgos;

//import static SortingAlgos.FindDuplicate.swap;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr, int r, int c) {
        if (r == 0 || r == 1) {
            return;
        }
        if (c < r) {
            if (arr[c] < arr[c - 1]) {
                swap(arr, c, c -1);
            }
            sort(arr, r, ++c);
        } else {
            sort(arr, --r, 1);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]){
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }// end of inner for
            if (flag)
                break;
        }// end of outer for
    }//end of bubble sort

    public static void bsByRecursion(int[] arr, int i) {
        if (i == arr.length - 2) {
            return;
        }
        boolean flag = true;
        for (int j = 1; j < arr.length - i; j++) {
            if (arr[j] < arr[j - 1]) {
                flag = false;
                swap(arr, j, j - 1);
            }
        }
        if (flag) {
            return;
        }
        bsByRecursion(arr, ++i);
    }

    public static void swap(int[] arr, int first, int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
