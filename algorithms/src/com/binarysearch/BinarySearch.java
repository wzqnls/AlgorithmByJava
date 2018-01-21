package com.binarysearch;

public class BinarySearch {

    private BinarySearch(){}

    // 非递归二分查找
    public static int find(Comparable[] arr, Comparable target) {

        // 在arr[l, r]中进行查找
        int l = 0, r = arr.length - 1;
        while(l <= r) {

            // 保证不会越界
            int mid = l + (r - l) / 2;

            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            else if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Integer(i);
        }

        System.out.println(BinarySearch.find(arr, 999));
    }
}
