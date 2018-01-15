package com.quicksort;

import com.utils.SortTest;

import java.util.Arrays;

public class QuickSort {

    private QuickSort(){}

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];

        // arr[l+1...j] < v; arr[j+1...i] > v
        int j = l;
        for(int i = l + 1; i <= r; i++) {
            if(arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static void sort(Comparable[] arr, int l, int r) {
        if(l >= r) {
            return;
        }

        int p = partition(arr, l , r);
        sort(arr, l , p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int num = 10000;
        Integer[] arr = SortTest.generateRandomArray(num, 0, 10000000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTest.testSort("com.quicksort.QuickSort", arr);
        SortTest.testSort("com.bubblesort.BubbleSort", arr2);
    }
}
