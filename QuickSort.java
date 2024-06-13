package SortingAlgos;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
//        int[] arr2 = new int[1000_000_000];
        fillArray(arr);
        System.out.println("Array Filled with random values.");
        qs(arr);
//        ms(arr2);
        System.out.println("Arrays sorted");
        checkSort(arr);
    }

    public static void qs(int[] arr) {
        long startTime = System.currentTimeMillis();
        qSort(arr);
//        Arrays.sort(arr);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time Taken Quick Sort : " + timeTaken / 1000.0 + " s");
    }

    public static void ms(int[] arr) {
        long startTime = System.currentTimeMillis();
        MergeSort.mergeSortInPlace(arr);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time Taken Merge Sort : " + timeTaken/1000.0 + " s");
    }

    private static void checkSort(int[] arr) {
        boolean sort = true;
        int index1 = 0;
        int index2 = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sort = false;
                index1 = i;
                index2 = i - 1;
                break;
            }
        }
        if (sort) {
            System.out.println("Passed!!");
        } else {
            System.out.println("Failed!!");
            System.out.println("Index " + index1 + " should come before index " + index2);
        }
    }

    private static void fillArray(int[] arr) {
        Random rn = new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = rn.nextInt();
            arr[i] = num;
        }
    }

    private static void qSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    public static void qSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(arr, low, high);

        qSort(arr, low, index - 1);
        qSort(arr, index + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
//        int pivotIndex = new Random().nextInt(high - low) + low;
        int pivotIndex = low + (high - low) / 2;
        int pivot = arr[pivotIndex];
        int lp = low;
        int rp = high;
        //taking the pivot to the last of the array
        swap(arr, pivotIndex, high);

        while (lp < rp) {
            while (arr[lp] <= pivot && lp < rp) {
                lp++;
            }

            while (arr[rp] >= pivot && lp < rp) {
                rp--;
            }
            swap(arr, lp, rp);
        }
        swap(arr, lp, high);

        return lp;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
