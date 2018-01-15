package com.quicksort;

import com.utils.SortTest;

import java.util.Arrays;

/**
 * @author lishuo
 * 双路快速排序算法
 * 对于存在大量重复键值得数组有很大性能提升
 */
public class QuickSort2Ways {

    private QuickSort2Ways(){}

    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr, l, (int)(Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];

        int i = l + 1;
        int j = r;
        while(true) {
            while(i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while(j >= l + 1 && arr[j].compareTo(v) > 0) {
                j--;
            }

            if(i > j) {
                break;
            }

            // 将v放置正确位置，即交换l, j位置，并继续移动
            swap(arr, l, j);
            i++;
            j--;
        }

        return j;
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {

        if(l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int num = 1000000;
        Integer[] arr = SortTest.generateRandomArray(num, 0, 100);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTest.testSort("com.quicksort.QuickSort2Ways", arr);
        SortTest.testSort("com.quicksort.RandomQuickSort", arr);
    }
}
