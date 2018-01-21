package com.binarysearch;

public class BinarySearch2 {

    private BinarySearch2(){}

    private static int find(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        }
        else if (arr[mid].compareTo(target) < 0) {
            return find(arr, mid + 1, r, target);
        }
        else {
            return find(arr, l, mid - 1, target);
        }
    }

    public static int find(Comparable[] arr, Comparable target) {
        return find(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Integer(i);
        }

        System.out.println(BinarySearch2.find(arr, 999));
    }
}
