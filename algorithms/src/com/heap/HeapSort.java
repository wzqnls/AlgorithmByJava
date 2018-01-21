package com.heap;

import com.utils.SortTest;

public class HeapSort {

    private HeapSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        /**
         * 现在堆排序索引从0开始
         * 最后一个元素 n - 1
         *
         */
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown2(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown2(arr, i, 0);
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    // 原始的shiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k){

        while( 2*k+1 < n ){
            int j = 2*k+1;
            if( j+1 < n && arr[j+1].compareTo(arr[j]) > 0 )
                j += 1;

            if( arr[k].compareTo(arr[j]) >= 0 )break;

            swap( arr, k, j);
            k = j;
        }
    }

    /**
     * 优化后的shiftDown，使用复制取代swap
     * 与之前插入排序优化思路一致
     *
     */
    private static void shiftDown2(Comparable[] arr, int n, int k) {
        Comparable e = arr[k];
        while(2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j += 1;
            }

            if (e.compareTo(arr[j]) >= 0) {
                break;
            }

            arr[k] = arr[j];
            k = j;
        }

        arr[k] = e;
    }

    public static void main(String[] args) {
        int N = 10000000;
        Integer[] arr = SortTest.generateRandomArray(N, 0, 1000000);
        SortTest.testSort("com.heap.HeapSort", arr);
    }
}
