package com.quicksort;

import com.utils.SortTest;

import java.util.Arrays;

/**
 * @author lishuo
 * 三路快速排序算法
 * 针对双路快排的一定优化
 */
public class QuickSort3Ways {

    private QuickSort3Ways(){}

    private static void sort(Comparable[] arr, int l, int r) {
        if(l >= r) {
            return;
        }

//        if(r - l <= 20) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        // 随机标定点
        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        /**
         * 设定索引下标
         * arr[l + 1 ... lt] < v
         * arr[gt ... r] > v
         * arr[lt + 1 ... i) == v
         */
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while(i < gt) {
            if(arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;

            }
            else if(arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;

            }
            i++;

        }
        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);

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
        int num = 10000000;
        Integer[] arr = SortTest.generateRandomArray(num, 0, 10);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortTest.testSort("com.quicksort.QuickSort3Ways", arr);
//        SortTest.testSort("com.quicksort.QuickSort2Ways", arr2);
    }
}
