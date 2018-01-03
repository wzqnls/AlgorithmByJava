package com.insertionsort;

public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 8, 12, 17, 6, 5, 2, 1};
        InsertionSort.sort(arr);

        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
