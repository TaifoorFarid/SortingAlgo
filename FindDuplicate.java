package SortingAlgos;

import java.util.*;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {3, 1, 8, 4, 2, 2, 7, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> ans = duplicates(arr);

        for (int i : ans){
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr)
    {
        int i = 0;
        int dup = -1;
        while (i < arr.length)
        {
            if ((arr[i] != arr[arr[i] - 1]) && arr[i] != i + 1)
                swap(arr, i, arr[i] - 1);
            else
                i++;
        }
    }
    private static void swap(int[] arr, int first, int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static ArrayList<Integer> duplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                ans.add(arr[i]);
        }

        return ans;
    }
}
