package com.insertionsort;

public class InsertionSort {

    private InsertionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0) {
                    swap(arr, j, j-1);
                }else {
                    break;
                }
            }
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {
        assert l >= 0 && l <= r && r < arr.length;

        for(int i = l + 1; i <= r; i++) {
            for(int j = i; j > 0; i--) {
                if(arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
                else {
                    break;
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
