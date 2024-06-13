package SortingAlgos;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 5, 4, 7, 1};
        zeroCyc(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(checkMissing(arr));

    }

    public static void cyclic(int[] arr)
    {
        int i = 0;//           index 0, 1, 2, 3, 4
        while (i < arr.length) //    3, 5, 2, 1, 4
        {
            if (arr[i] != i + 1)
            {
                swap(arr, i, arr[i] - 1);
            } else
                i++;
        }
    }

    public static void swap(int[] arr, int first, int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void zeroCyc(int[] arr)
    {
        int i = 0;
        int n = arr.length;
        while (i < n)
        {
            if(arr[i] >= n)
                i++;
            else if (arr[i] != i)
                swap(arr, i, arr[i]);
            else
                i++;
        }
    }

    static int checkMissing(int[] arr)// 0, 1, 2, 3, 5
    {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i)
                return i;
        }
        return i;
    }
}
