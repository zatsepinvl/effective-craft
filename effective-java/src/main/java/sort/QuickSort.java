package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = left + (right - left) / 2;
        int pivot = array[pivotIndex];
        int i = left;
        int j = right;
        while (true) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i >= j) break;
            swap(array, i, j);
        }
        sort(array, left, pivotIndex);
        sort(array, pivotIndex + 1, right);
    }

    private static void swap(int[] array, int a, int b) {
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }

}
